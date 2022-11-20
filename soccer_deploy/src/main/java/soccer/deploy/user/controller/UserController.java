package soccer.deploy.user.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.dto.LoginForm;
import soccer.deploy.user.dto.UserDto;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.service.UserService;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("loginForm") LoginForm loginForm){
		return "view/user/login";
	}
	
	@PostMapping("/login")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm , BindingResult bindingResult, HttpServletResponse response,
						@RequestParam(name = "redirect", defaultValue = "/xMain") String redirect, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/view/user/login";
		}
		
		User loginUser = userService.login(loginForm.getEmail(), loginForm.getPasswd());
		System.out.println(loginUser);
		
		if(loginUser==null) {
			bindingResult.reject("loginFail", "ID와 비밀번호를 확인하여 주십시오");
			return "/view/user/login";
		}
		
		Cookie loginCookie = new Cookie("loginUser", loginUser.getName());
		loginCookie.setPath("/");
		response.addCookie(loginCookie);
		model.addAttribute("loginUser", loginCookie);
		
		return "redirect:"+redirect;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("loginUser", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/xMain";
	}
	
	@GetMapping("/regist")
	public String registPage(@ModelAttribute("user") User user) {
		return "/view/user/signup";
	}
	
	@PostMapping("/regist")
	public String registerForm(@Validated @ModelAttribute("user") UserDto user, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
				if (bindingResult.hasErrors()) {
					log.info("bindingResults : {}", bindingResult);
					return "/view/user/signup";
				}
				
		User registUser = new User();
		registUser.setEmail(user.getEmail());
		registUser.setPasswd(user.getPasswd());
		registUser.setAge(user.getAge());
		registUser.setName(user.getName());
		registUser.setAddress(user.getAddress());
		registUser.setBackNum(user.getBackNum());
		registUser.setImgContType(user.getImgContType());
		registUser.setImgFileName(user.getImgFileName());
		registUser.setPosition(user.getPosition());
		registUser.setRegdate(user.getRegdate());
		registUser.setMemberAuth(user.getMemberAuth());
		
		Long userId = userService.register(registUser);
		
		redirectAttributes.addAttribute("userId", userId);
		redirectAttributes.addAttribute("status", true);
		
		
		return "redirect:/user/{userId}";
	}
	
	@GetMapping("/{userId}")
	public String registUserView(@PathVariable Long userId , Model model) {
		Optional<User> user = userService.findUser(userId);
		model.addAttribute("user", user.get());
		log.info("가입한 회원 정보{}",user);
		return "view/user/profile";
	}
	
	@GetMapping("/list")
	public String userListView(Model model, @PageableDefault(size = 10, page=0) Pageable pageable,
								@RequestParam(required = false, defaultValue = "") String value) {
		
		Page<User> userList =userService.searchUser(value,pageable);
		
		int pageNumber = userList.getPageable().getPageNumber()+1;
		int totalPage = userList.getTotalPages();
		int pageBlock = 5;
		int startBlockPage = (pageNumber/pageBlock)*pageBlock+1;
		int endBlockPage = startBlockPage+pageBlock-1;
		endBlockPage = endBlockPage>totalPage ? totalPage : endBlockPage ;
		
		model.addAttribute("userList", userList);
		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);	
		return "view/players";
	}
}
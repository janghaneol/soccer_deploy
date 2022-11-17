package soccer.deploy.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.dto.LoginForm;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.service.UserService;

@Controller
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("loginForm") LoginForm loginForm){
		return "view/user/login";
	}
	
	@PostMapping("/login")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm , BindingResult bindingResult, HttpServletResponse response,
						@RequestParam(name = "redirect", defaultValue = "/xMain") String redirect) {
		
		if(bindingResult.hasErrors()) {
			return "/view/user/login";
		}
		
		User loginUser = userService.login(loginForm.getEmail(), loginForm.getPasswd());
		System.out.println(loginUser);
		
		if(loginUser==null) {
			bindingResult.reject("loginFail", "id와 password를 확인하여 주십시오");
			return "/view/user/login";
		}
		
		Cookie loginCookie = new Cookie("loginUser", loginUser.getName());
		loginCookie.setPath("/");
		response.addCookie(loginCookie);
		
		
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
}
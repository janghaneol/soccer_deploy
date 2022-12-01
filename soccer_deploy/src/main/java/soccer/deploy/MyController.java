package soccer.deploy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import soccer.deploy.dto.noticeDTO;
import soccer.deploy.dto.usersDTO;
import soccer.deploy.service.noticeService;
import soccer.deploy.service.usersService;
import soccer.deploy.user.entity.User;

@Controller
public class MyController {
	
	@Autowired 
	private usersService UsersService;
	
	@Autowired
	private noticeService NoticeService;
	
//	@RequestMapping("/") Cookie를 통한 로그인 유지 및 관리
	public String index(Model model,@CookieValue(name = "loginUser", required = false) String loginUser) {
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "index";
	}
	
	@RequestMapping("/")
	public String sessionIndex(@SessionAttribute(name = "loginUser",required = false ) User loginUser ,Model model) {
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
		}
		return "index";
	}
	
	
	
	@RequestMapping("/main")
	public String main() {
		
		return "view/main";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "view/contact";
	}
	
	
	
	@RequestMapping("/matches")
	public String matches() {
		
		return "view/matches";
	}
	
	
	@RequestMapping("/single")
	public String single() {
		
		return "view/single";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		
		return "view/blog";
	}
	@RequestMapping("/mainPage")
	public String mainPage() {
		
		return "view/mainPage";
	}
	@RequestMapping("/login")
	public String login() {
		
		return "view/user/login";
	}
	@RequestMapping("/xMain")
	public String xMain() {
		
		return "view/xMain";
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}

	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		
		List<noticeDTO> select = NoticeService.select();
		
		model.addAttribute("select", select);
		
		return "notice";
	}
}

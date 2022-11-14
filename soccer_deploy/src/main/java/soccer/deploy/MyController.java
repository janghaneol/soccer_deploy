package soccer.deploy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String index() {

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
	
	@RequestMapping("/players")
	public String players() {
		
		return "view/players";
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
//	@GetMapping("/test")
//	public String lineUp() {
//		return "view/lineUp/lineUp";
//	}
}

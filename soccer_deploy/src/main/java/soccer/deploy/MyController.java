package soccer.deploy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import soccer.deploy.dto.noticeDTO;
import soccer.deploy.dto.usersDTO;
import soccer.deploy.service.noticeService;
import soccer.deploy.service.usersService;

@Controller
public class MyController {
	
	@Autowired 
	private usersService UsersService;
	
	@Autowired
	private noticeService NoticeService;
	
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

	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}
	
//	Mybatis遺꾨뱾�� �씠嫄� 蹂대㈃�꽌 �븯硫� �룄���씠 �맆嫄곗삁�슂!
	@RequestMapping("/users")
	public String users(Model model) {
		
		List<usersDTO> select = UsersService.select();
		
		model.addAttribute("select", select);
		
		return "users";
	}
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		
		List<noticeDTO> select = NoticeService.select();
		
		model.addAttribute("select", select);
		
		return "notice";
	}
	
	@RequestMapping("/xnotice")
	public String xnotice(Model model) {
		
		List<noticeDTO> select = NoticeService.select();
		
		model.addAttribute("select", select);
		
		return "xnotice";
	}
}

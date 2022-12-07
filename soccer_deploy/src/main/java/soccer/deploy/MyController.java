package soccer.deploy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}

	@RequestMapping("/users")
	public String users(Model model) {

		return "users";
	}

	@RequestMapping("/notice")
	public String notice(Model model) {

		return "notice";
	}

	@RequestMapping("/xnotice")
	public String xnotice(Model model) {

		return "xnotice";

	}
}

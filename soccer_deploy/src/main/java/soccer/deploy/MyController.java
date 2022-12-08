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

	//시작
	@RequestMapping("/")
	public String index() {

		return "index";
	}

	//채팅예시, 스와이퍼
	@RequestMapping("/main")
	public String main() {

		return "view/main";
	}

	//네개의 컬럼 보내기
	@RequestMapping("/contact")
	public String contact() {

		return "view/contact";
	}

	//대진표
	@RequestMapping("/matches")
	public String matches() {

		return "view/matches";
	}

	//선수에대한 정보(표)
	@RequestMapping("/players")
	public String players() {

		return "view/players";
	}

	//댓글
	@RequestMapping("/single")
	public String single() {

		return "view/single";
	}

	//블로그
	@RequestMapping("/blog")
	public String blog() {

		return "view/blog";
	}

	//옛날 내가만든거. 데이터 뿌리기용으로 쓰세요
	@RequestMapping("/mainPage")
	public String mainPage() {

		return "view/mainPage";
	}

	//로그인
	@RequestMapping("/login")
	public String login() {

		return "view/user/login";
	}

	//채팅과 로그인으로 들어가는 버튼
	@RequestMapping("/xMain")
	public String xMain() {

		return "view/xMain";
	}
	
	//회원가입
	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}

	//경기장 그림
	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}

	//지금 만들 공지사항
	@RequestMapping("/xnotice")
	public String xnotice(Model model) {

		return "xnotice";

	}
}

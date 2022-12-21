package soccer.deploy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
//	@RequestMapping("/") Cookie를 통한 로그인 유지 및 관리 Session으로 변경했습니다.
	public String index(Model model,@CookieValue(name = "loginUser", required = false) String loginUser) {
		if(loginUser != null) {
			model.addAttribute("loginUser", loginUser);
		}
		return "index";
	}
	
	/*Session을 통한 로그인 유지 및 관리*/
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
	
	@RequestMapping("/notice")
	public String notice(Model model) {
		
		List<noticeDTO> select = NoticeService.select();
		
		model.addAttribute("select", select);
		
		return "notice";
	}
}

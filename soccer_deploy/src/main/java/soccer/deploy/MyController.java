package soccer.deploy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.board.service.BoardService;
import soccer.deploy.match.myDto.MatchDto;
import soccer.deploy.match.myDto.rank;
import soccer.deploy.match.myService.MatchChoungService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.user.entity.User;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchChoungService matchChoungService;
	@Autowired
	private BoardService boardService;
	
	/*Session을 통한 로그인 유지 및 관리*/
	@GetMapping("/")
	public String sessionIndex(@SessionAttribute(name = "loginUser",required = false ) User loginUser ,Model model) {
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
		}
	
		
		List<Long> resultId = matchChoungService.findRecentTwoResultMatchId();
		HashMap<String, MatchDto> resultMatch = matchChoungService.recentTwoMatchResult(resultId);
		HashMap<String, List<rank>> resultPlayer = matchChoungService.recentTwoMatchPlayer(resultId);
		Long viewMatchId = matchService.findRecentViewMatch();
		model.addAttribute("recentMatch",matchService.findeRecentMatch(viewMatchId));
		model.addAttribute("resultMatch", resultMatch);
		model.addAttribute("resultPlayer", resultPlayer);
		
		return "index";
	}
	
	
	
	@GetMapping("/main")
	public String main() {

		return "view/main";
	}

	//네개의 컬럼 보내기
	@GetMapping("/contact")
	public String contact() {

		return "view/contact";
	}

	//대진표
	@GetMapping("/matches")
	public String matches() {

		return "view/matches";
	}
	
	
	@GetMapping("/single")
	public String single() {

		return "view/single";
	}

	//블로그
	@GetMapping("/blog")
	public String blog() {

		return "view/blog";
	}

	//옛날 내가만든거. 데이터 뿌리기용으로 쓰세요
	@GetMapping("/mainPage")
	public String mainPage() {

		return "view/mainPage";
	}

	//로그인
	@GetMapping("/login")
	public String login() {

		return "view/user/login";
	}


	//회원가입
	@GetMapping("/signup")
	public String signUp() {
		return "signup";
	}

	//경기장 그림
	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}
	
	@GetMapping("/findRoad")
	public String road(Model model) {
		
		Long viewMatchId = matchService.findRecentViewMatch();
		model.addAttribute("recentMatch",matchService.findeRecentMatch(viewMatchId));
		
		return "view/roadPop";
	}

}

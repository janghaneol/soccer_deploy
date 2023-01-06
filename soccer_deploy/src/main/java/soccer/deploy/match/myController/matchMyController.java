package soccer.deploy.match.myController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.MyEntry.EntryMyDao;
import soccer.deploy.MyEntry.EntryMyService;
import soccer.deploy.MyUser.UserMyDto;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.entry.service.EntryServiceImpl;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.matchMyDto;
import soccer.deploy.match.myService.matchMyService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.user.entity.User;

@Controller
@RequestMapping("/match")
@Slf4j
public class matchMyController {
	
	@Autowired
	private EntryMyService entryMyService;
	@Autowired
	private matchDao MatchDao; 
	@Autowired
	private JpaEntryRepository entryService;
	@Autowired
	private MatchService m;
	@GetMapping
	public String matchList(Model model) {
		List<matchMyDto> list = MatchDao.list();
		model.addAttribute("list", list);
		log.info("{}",list);
		
		return "view/match/match"; 
	}
	
	//match 등록
//	@PostMapping("/schedule")
//	public String matchRegist() {
//		return null;
//	}
	
	@GetMapping("/asd")
	public String test(@RequestParam("matchId")String matchId,  HttpSession session)
	{   //로그인 세션값
		Entry entry =new Entry();
		entry.setMatch(m.findeRecentMatch(Long.parseLong(matchId)));
		entry.setUser((User) session.getAttribute("loginUser"));
		log.info("{}",matchId);
		entryService.save(entry);
		return "view/match/match";
	}
	
	@GetMapping("/schedule")
	public String matchSchedule() {
		
		return "view/match/schedule";
	}
	
	@GetMapping("/result")
	public String matchResult() {
		
		return "view/match/matchResult";
	}
	
//	팝업 리스트
	@GetMapping("/popup")
	public String popupList(Model model) {
		
		List<UserMyDto> list = entryMyService.show();
		model.addAttribute("popupList",list);
		
		return "view/match/popup";
	}

	
}

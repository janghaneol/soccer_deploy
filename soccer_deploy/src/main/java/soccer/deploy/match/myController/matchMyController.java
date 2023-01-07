package soccer.deploy.match.myController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.MyEntry.EntryMyService;
import soccer.deploy.MyUser.UserMyDto;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myService.MatchChoungService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.service.QuarterService;
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
	@Autowired
	private MatchChoungService matchService;
	@Autowired
	private QuarterService quarterService;
	
	/*
	 * 경기일정을 보여줌
	 */
	@GetMapping

	public String matchList(Model model,@RequestParam(required = false, defaultValue = "first") String matchYear, @RequestParam(required = false,defaultValue = "first") String matchMonth) {
		model.addAttribute("result", m.findMatch(matchYear, matchMonth));
		model.addAttribute("year", m.matchYear());
		model.addAttribute("month",m.month());
		log.info("List : {}", m.findMatch(matchYear, matchMonth));
		log.info("year : {}",matchYear);
		return "view/match/match"; 
	}
	   
	/*
	 * 경기일정 등록화면
	 */
	@GetMapping("/schedule")
	public String matchSchedule(Model model) {
		return "view/match/schedule";
	}
	
	@PostMapping("/schedule")
	public String matchSchedule(@ModelAttribute Match match,RedirectAttributes redirectAttributes,@RequestParam String publeYear, String time, HttpSession session,
								@RequestParam String add2, String add3 , @RequestParam(required = false, defaultValue = "1") String quarterNumber, 
								@RequestParam(required = false, defaultValue = "30") String quarterTime) {
		Match registMatch = new Match();
		List<Quarter> quarters = new ArrayList<Quarter>();
		String date = publeYear+" "+time;
		String address = add2 + " " + add3;
		Date mDate = null;
		int qNum = Integer.parseInt(quarterNumber);
		int qTime = Integer.parseInt(quarterTime);
		log.info("경기 시간: {} " , date);
		
		/*
		 * 경기등록 부분
		 */
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm");
		try {
			mDate =dateFormat.parse(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		registMatch.setMatchDate(mDate);
		registMatch.setOpteam(match.getOpteam());
		registMatch.setMatchPlace(address);
		registMatch.setUser((User)session.getAttribute("loginUser"));
		Long matchId = m.registMatch(registMatch);
		
		/*
		 * 쿼터 등록 부분
		 */
		while (qNum --> 0) {
			Quarter quarter = new Quarter();
			quarter.setMatch(registMatch);
			quarter.setMatchId(registMatch.getId());
			quarter.setQuarterTime(qTime);
			quarters.add(quarter);
		}
		quarterService.registQuarter(quarters);
		
		redirectAttributes.addAttribute("matchId", matchId);
		return "redirect:/match";
	}

	
	@GetMapping("/asd")
	public String test(@RequestParam("matchId")String matchId,  HttpSession session)
	{   //濡쒓렇�씤 �꽭�뀡媛�
		Entry entry =new Entry();
		entry.setMatch(m.findeRecentMatch(Long.parseLong(matchId)));
		entry.setUser((User) session.getAttribute("loginUser"));
		entryService.save(entry);
		log.info("{}",entry.getUser());
		return "redirect:/match";
	}
	
	@GetMapping("/result")
	public String matchResult(@RequestParam(value= "Year", required = false, defaultValue = "first") String rankYear, @RequestParam(value= "Month", required = false, defaultValue = "first") String rankMonth, Model model) {
		model.addAttribute("result", matchService.matchResult(rankYear, rankMonth));
		model.addAttribute("year", matchService.year());
		model.addAttribute("month",matchService.month());
		log.info("resutl::{}", matchService.matchResult(rankYear, rankMonth));
		return "view/match/matchResult";
	}

	
//	팝업 리스트
	@GetMapping("/popup")
	public String popupList(Model model) {
		
		List<UserMyDto> list = entryMyService.show("1");
		model.addAttribute("popupList",list);
		
		return "view/match/popup";
	}

	

	@GetMapping("/rank")
	public String rank(@RequestParam(value= "Year", required = false, defaultValue = "first") String rankYear, @RequestParam(value= "Month", required = false, defaultValue = "first") String rankMonth, Model model) {
		model.addAttribute("rank", matchService.rank(rankYear, rankMonth));
		model.addAttribute("year", matchService.year());
		model.addAttribute("month",matchService.month());

		return "view/match/rank";
	}
	
	@GetMapping("/kas")
	public String tese() {
		return "view/board/boardView";
	}

}


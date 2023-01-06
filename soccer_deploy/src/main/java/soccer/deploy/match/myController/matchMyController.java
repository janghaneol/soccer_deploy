package soccer.deploy.match.myController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.matchMyDto;
import soccer.deploy.match.myService.MatchChoungService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.user.entity.User;

@Controller
@RequestMapping("/match")
@Slf4j
public class matchMyController {
	
	@Autowired
	private matchDao MatchDao; 
	@Autowired
	private JpaEntryRepository entryService;
	@Autowired
	private MatchService m;
	@Autowired
	private MatchChoungService matchService;
	
	/*
	 * 경기일정을 보여줌
	 */
	@GetMapping
	public String matchList(Model model,@RequestParam(required = false, defaultValue = "2023") String matchYear, @RequestParam(required = false,defaultValue = "") String matchMonth) {
		String date = matchYear.substring(2) +"/" + matchMonth;
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		
		log.info("검색한 매치 : {}",date);
		List<Match> list = m.findMatchdate(date);
		model.addAttribute("list", list);
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("matchYear",matchYear);
		model.addAttribute("matchMonth",matchMonth);
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
								@RequestParam String add2, String add3) {
		Match registMatch = new Match();
		String date = publeYear+" "+time;
		String address = add2 + " " + add3;
		log.info("시간:{}",date);
		Date mDate = null;
		/*
		 * 	22/12/29 04:00 의 형태로 Date를 저장하려면 DB에서 session값을 바꿔줘야됩니다!
		 *  alter session set nls_date_format = 'yyyy-MM-dd hh24:mi';
		 *  위의 줄을 SQL에서 실행해주세요~
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
	@GetMapping("/rank")
	public String rank(@RequestParam(value= "Year", required = false, defaultValue = "first") String rankYear, @RequestParam(value= "Month", required = false, defaultValue = "first") String rankMonth, Model model) {
		model.addAttribute("rank", matchService.rank(rankYear, rankMonth));
		model.addAttribute("year", matchService.year());
		model.addAttribute("month",matchService.month());

		return "view/match/rank";
	}
	@GetMapping("/test")
	public String listResult(@RequestParam(name = "redirect", defaultValue = "/match/result") String redirect) {
		
		return "redirect:"+redirect;
	}
}


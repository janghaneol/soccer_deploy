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
	public String matchList(Model model) {
		List<matchMyDto> list = MatchDao.list();
		model.addAttribute("list", list);
		log.info("{}",list);
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
	public String matchSchedule(@ModelAttribute Match match,RedirectAttributes redirectAttributes,@RequestParam String publeYear, String time) {
		Match registMatch = new Match();
		String date = publeYear+time;
		
		/*
		 * 	22/12/29 04:00 의 형태로 Date를 저장하려면 DB에서 session값을 바꿔줘야됩니다!
		 *  alter session set nls_date_format = 'yyyy-MM-dd hh24:mi';
		 *  위의 줄을 SQL에서 실행해주세요~
		 */
		
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd HH:mm");
		try {
			Date mDate =dateFormat.parse(date);
			registMatch.setMatchDate(mDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		registMatch.setOpteam(match.getOpteam());
		registMatch.setMatchPlace(match.getMatchPlace());
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
		log.info("{}",matchId);
		entryService.save(entry);
		log.info("{}",entry.getUser());
		return "view/match/match";
	}
	
	@GetMapping("/result")
	public String matchResult() {
		
		return "view/match/matchResult";
	}
	@GetMapping("/test")
	public String rank(@RequestParam(value= "rankYear", required = false, defaultValue = "first") String rankYear, @RequestParam(value= "rankMonth", required = false, defaultValue = "first") String rankMonth, Model model) {
//		log.info("year:{}",matchService.year());
		log.info("year:{} , month:{}",rankYear, rankMonth);
		log.info("rank:{}",matchService.rank(rankYear, rankMonth));
		model.addAttribute("rank", matchService.rank(rankYear, rankMonth));
		model.addAttribute("year", matchService.year());
		model.addAttribute("month",matchService.month());

		return "view/match/rank";
	}
}

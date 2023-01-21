package soccer.deploy.lineUp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.lineUp.entity.LineUpDto;
import soccer.deploy.lineUp.entity.LineUpListDto;
import soccer.deploy.lineUp.service.LineUpService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.entity.QuarterListDto;
import soccer.deploy.quarter.service.QuarterService;
import soccer.deploy.user.service.UserService;

@Controller
@RequestMapping("/lineup")
@Slf4j
public class LineUpController {
	@Autowired
	private MatchService matchService;
	@Autowired
	private EntryService entryService;
	@Autowired
	private QuarterService quarterService;
	@Autowired 
	private UserService userService;
	@Autowired
	private LineUpService lineUpService;


	//처음 화면 출력부분
	@GetMapping
	public String lineUpview(Model model,HttpServletRequest request) {
		Long recentMatch = matchService.findRecentMatchNum();
		List<Entry> entry = entryService.findEntryRecentMatch(recentMatch);
		int test= 0;
		if(entry.size() == 0) {
			log.info("주소테스트{}",request.getHeader("Referer"));
			return "redirect:"+request.getHeader("Referer");
		}else {
			List<Quarter> quarter = quarterService.findQuarterRecentMatch(recentMatch);
			model.addAttribute("entry", entry);
			model.addAttribute("quarter", quarter);
			log.info("{}",recentMatch);
			return "view/lineUp/lineUp";
		}
	}

	// 검색 비동기로 post로
	@PostMapping
	@ResponseBody
	public List<Entry> search(@RequestBody String name) throws IOException{
		Long recentMatch = matchService.findRecentMatchNum();
		name = name.replaceAll("\"", "");
		List<Entry> entrys = entryService.SearchRecentEntry(recentMatch, name);
		return entrys;
	}

	// 페이지 이동시 자동으로 세션에 저장 하지만 그전에 물어보는 창 나오게 해서 취소시는 저장 x 확인시 저장
	@PostMapping("/entry")
	@ResponseBody
	public void saveEntry(@RequestBody List<LineUpDto> list, HttpSession session) throws IOException{
		session.setAttribute("lineup", list);
		
	}

	@GetMapping("/result")
	public String lineUpReg(HttpSession session,Model model, HttpServletRequest request) {
		String before_address = request.getHeader("referer");
		log.info("이전주소{}",before_address);
		Long recentMatch = matchService.findRecentMatchNum();
		List<Quarter> quarter = quarterService.findQuarterRecentMatch(recentMatch);
		model.addAttribute("quarter",quarter);
		model.addAttribute("redirect",before_address);
		log.info("{}",quarter);
		return "view/match/matchResultReg";
	}

	@PostMapping("/result")
	public String regResult(@ModelAttribute("LineUpListDto") LineUpListDto L, @ModelAttribute("QuarterListDto") QuarterListDto Q,HttpSession session){
		log.info("L:{}",L.getLineUpList());
		log.info("Q'{}",Q.getQuarterList());
		quarterService.updateInsertQuarter(Q.getQuarterList());
		lineUpService.insertLineUp(L.getLineUpList());
		session.removeAttribute("lineup");
		return "redirect:/match/result";
	}
}

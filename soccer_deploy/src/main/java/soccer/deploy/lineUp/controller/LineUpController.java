package soccer.deploy.lineUp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.service.QuarterService;

@Controller
@RequestMapping("/lineup")
public class LineUpController {
	@Autowired
	private MatchService matchService;
	@Autowired
	private EntryService entryService;
	@Autowired
	private QuarterService quarterService;
	
	//처음 화면 출력부분
	@GetMapping
	public String lineUpview(Model model) {
		Long recentMatch = matchService.findRecentMatch();
		List<Entry> entry = entryService.findEntryRecentMatch(recentMatch);
		List<Quarter> quarter = quarterService.findQuarterRecentMatch(recentMatch);
		model.addAttribute("entry", entry);
		model.addAttribute("quarter", quarter);
		return "view/linUp/lineUp";
	}
	// 검색 비동기로 post로
	// 페이지 이동시 자동으로 세션에 저장 하지만 그전에 물어보는 창 나오게 해서 취소시는 저장 x 확인시 저장
}

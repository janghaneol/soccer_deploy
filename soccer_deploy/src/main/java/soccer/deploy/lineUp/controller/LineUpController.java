package soccer.deploy.lineUp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.service.QuarterService;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;
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
	
	//처음 화면 출력부분
	@GetMapping
	public String lineUpview(Model model) {
		Long recentMatch = matchService.findRecentMatchNum();
		List<Entry> entry = entryService.findEntryRecentMatch(recentMatch);
		List<Quarter> quarter = quarterService.findQuarterRecentMatch(recentMatch);
		model.addAttribute("entry", entry);
		model.addAttribute("quarter", quarter);
		
		return "view/lineUp/lineUp";
	}
	// 검색 비동기로 post로
	@PostMapping
	@ResponseBody
	public List<User> search(@RequestBody String name) throws IOException{
		Long recentMatch = matchService.findRecentMatchNum();
		name = name.replaceAll("\"", "");
			
		List<User> users = userService.searchEntryUsers(recentMatch, name);
		log.info("{}",users);
		return users;
//		return null;
	}
	// 페이지 이동시 자동으로 세션에 저장 하지만 그전에 물어보는 창 나오게 해서 취소시는 저장 x 확인시 저장
	@PostMapping("/entry")
	@ResponseBody
	public String saveEntry(@RequestBody List<Object> list) throws IOException{
		log.info("{}",list);
		
		return "yes";

	}
}

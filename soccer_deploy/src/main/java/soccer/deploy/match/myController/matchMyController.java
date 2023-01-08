package soccer.deploy.match.myController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.matchMyDto;

@Controller
@RequestMapping("/match")
@Slf4j
public class matchMyController {
	
	@Autowired
	 matchDao MatchDao; 
	
	@GetMapping
	public String match_list(Model model) {
		List<matchMyDto> list = MatchDao.list();
		model.addAttribute("list", list);
		log.info("{}",list);
		return "view/match/match"; 
	}
}

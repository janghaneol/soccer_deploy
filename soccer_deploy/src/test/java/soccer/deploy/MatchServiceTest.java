
package soccer.deploy;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.repository.JpaMatchRepository;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.repository.JpaQuarterRepository;
import soccer.deploy.quarter.service.QuarterService;
import soccer.deploy.user.dto.UpdateUserDto;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;
import soccer.deploy.user.service.UserService;

@SpringBootTest

@Slf4j
public class MatchServiceTest {

	@Autowired
	private MatchService matchService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JpaMatchRepository matchRepository;
	
	@Autowired
	private JpaQuarterRepository quarterRepository;
	
	@Autowired
	private QuarterService quarterService;
	
	@Test
	@Disabled
	public void regist() {
		Date date = null;
		String matchdate = "22/01/23 23:00";
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd kk:mm");
		
		try {
			date = dateFormat.parse(matchdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}
		
		Match match = new Match();
		match.setMatchPlace("쿼터Test");
		match.setOpteam("쿼터등록 Test");
		match.setMatchDate(date);
		matchService.registMatch(match);
		log.info("등록된 매치의 ID : {}",match.getId());
		
		List<Quarter> quarter = new ArrayList<Quarter>();
		for(int i=0; i<4; i++) {
			Quarter registQuarterList = new Quarter();
			registQuarterList.setMatchId(match.getId());
			registQuarterList.setMatch(match);
			registQuarterList.setQuarterTime(30);
			quarter.add(registQuarterList);
			log.info("쿼터 ID : {} : ", registQuarterList.getMatchId());
		}
		quarterService.registQuarter(quarter);
		
		
//		quarter.setMatchId(match.getId());
//		quarter.setMatch(match);
//		quarter.setQuarterTime(30);
//		quarterService.registQuarter(quarter);
		log.info("해당 Match의 쿼터 : {}", quarter);
		
		
	}

	
	@Test
	@Disabled
	public void matchList() {
		String matchdate = "";
		List<Match> match = matchService.findMatchdate(matchdate);
		for (Match list : match) {
			log.info("검색한 매치 : {}",list);
		}
		
	}
	
	@Test
//	@Disabled
	public void findMatch() {
		Long match = matchService.findRecentViewMatch();
		log.info("최근 Match  : : : {}",matchService.findeRecentMatch(match));
	}
	
	@Test
	@Disabled
	public void update() {
		Match match = matchService.findeRecentMatch(3L);
		match.setMatchPlace("노원");
		matchService.modifyMatch(2L, match);
		log.info("수정된 매치의 정보 : {}",match);
	}
	
	@Test
	@Disabled
	public void delete() {
		Match delMatch = matchService.findeRecentMatch(3L);
		if(delMatch!=null) {
			log.info("삭제할 매치 : {}",delMatch);
			matchRepository.delete(delMatch);
		}
	}
	
}

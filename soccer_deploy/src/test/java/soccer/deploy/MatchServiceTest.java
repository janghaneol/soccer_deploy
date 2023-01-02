
package soccer.deploy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@Test
//	@Disabled
	public void regist() {
		Date date = null;
		String matchdate = "22/02/23 23:00";
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd kk:mm");
		
		try {
			date = dateFormat.parse(matchdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block		
			e.printStackTrace();
		}
		
		Match match = new Match();
		match.setMatchPlace("의정부");
		match.setOpteam("바르셀로나");
		match.setMatchDate(date);
		matchService.registMatch(match);
		log.info("등록된 매치의 ID : {}",match.getMatchDate());
		
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
	@Disabled
	public void findMatch() {
		Match match = matchService.findeRecentMatch(2L);
		log.info("검색한 경기 정보 : {}",match);
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

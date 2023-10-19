
package soccer.deploy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.repository.JpaMatchRepository;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.repository.JpaQuarterRepository;
import soccer.deploy.quarter.service.QuarterService;
import soccer.deploy.user.entity.User;
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
	private EntryService entryService;
	
	@Autowired
	private QuarterService quarterService;
	
	@Autowired
	private JpaEntryRepository entryRepository;
	
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
		String matchdate = "23/01";
		List<Match> match = matchService.findMatchdate(matchdate);
		HashMap<Long, List<Entry>> entryList = new HashMap<Long, List<Entry>>();

		for (Match matchs : match) {
				List<Entry> entry = entryService.findEntryRecentMatch(matchs.getId());
				entryList.put(matchs.getId(), entry);
 		}
		
		
		
		System.out.println("============ entryList Size ============  : : : "+entryList.size());
		System.out.println("============ Match Size ============= : : : : " + match.size());
	}
	
	@Test
	@Disabled
	public void entryList() {
//		List<Match> match = matchService.findMatch("23", "01");
//		for (Match matchs : match) {
//			log.info("찾은 Match : : {}", matchs);
//			List<Entry> entry = entryService.findEntryRecentMatch(matchs.getId());
//			for (Entry entrys : entry) {
//				log.info("해당 Match{} 의 Entry : : {}",matchs.getId(),entrys.getUser().getId());
//			}
//		}
		List<Entry> entry = entryRepository.findAll();
		for (Entry entry2 : entry) {
			log.info("entry : : : {} ",entry2.getMatch());
		}
		
		
		
	}
	
	@Test
	@Disabled
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
	
	@Test
	@Disabled
	public void cancelEntry() {
		Match match = matchService.findeRecentMatch(6L);
		log.info("Match{}",match);
		List<Entry> entrys = entryService.findEntryRecentMatch(match.getId());
		Optional<User> user = userService.findUser(4L);
		log.info("User{}",user.get());
		for (Entry entry : entrys) {
			if(entry.getUser().equals(user.get())) {
				log.info("Entry{}",entry.getUser().getId());
				entryService.deleteEntry(match.getId(), user.get());
			}
		}
		
	}
	
	@Test
	@Disabled
	public void boolList() {
		List<Match> matchs = matchService.findMatch("23", "02");
		Optional<User> user = userService.findUser(4L);
		for (Match match : matchs) {
			log.info("matchDate : : : {}",match.getMatchDate());
		}
//		List<Boolean> boolList2=entryService.findUserAndEntryByMatch(matchs, user.get());
//		log.info("boolList : : : {} ",boolList2);
	}
	
	@Test
	@Disabled
	public void cal() {
		List<Match> matchs = matchService.findMatch("23", "02");
		List<Boolean> boolList = matchService.matchExpiration(matchs);
		log.info("지났나 안지났나 {} ",boolList);
		
	}
	
	@Test
//	@Disabled
	public void userEntryList() {
		Optional<User> user = userService.findUser(4L);
		List<Entry> matchs = entryService.findEntryUserId(user.get().getId());
		for (Entry match : matchs) {
			log.info("match : : : {}", match);
		}
	}
}

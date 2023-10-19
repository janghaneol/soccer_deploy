package soccer.deploy;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.board.service.BoardService;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myService.MatchChoungService;
import soccer.deploy.match.service.MatchService;

@SpringBootTest
@Transactional
@Slf4j
public class choungTest {
	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchChoungService matchChoungService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private EntryService entryService;
	@Autowired
	private MatchService m;
	@Test
	@Disabled	
	void test1(){
		
	}
	
	@Test
	void test3() throws ParseException {
		LocalDateTime localDate = LocalDateTime.now();
		List<Match> match = m.findMatch("23", "10");
//		log.info("{}",match.get(0).getMatchDate().after(null))
//		List<Long> resultId = matchChoungService.findRecentTwoResultMatchId();
//		HashMap<String, MatchDto> resultMatch = matchChoungService.recentTwoMatchResult(resultId);
//		log.info("{}",resultMatch.get("second").getMatchId());
		Timestamp timestamp2 = Timestamp.valueOf(localDate);
		log.info("{}",timestamp2);
		log.info("{}",match.get(0).getMatchDate().getDate());
		log.info("{}",match.get(0).getMatchDate().after(timestamp2));
		log.info("{}",m.matchExpiration(match));
		
	}
}

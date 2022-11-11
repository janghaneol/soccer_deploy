package soccer.deploy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.service.QuarterService;

@SpringBootTest
@Transactional
@Slf4j
public class choungTest {
	@Autowired
	private EntryService entryService;
	@Autowired
	private QuarterService quarterService;
	@Autowired 
	private MatchService matchService;
	
	@Test
	@Disabled
	void test1(){
		for(Entry e :entryService.findEntryRecentMatch(1L)){
			
			log.info("{}",e.getUser().getImgContType());
		}
	}
	@Test
	@Disabled
	void test2() {
		for(Quarter q : quarterService.findQuarterRecentMatch(1L) ) {
			log.info("{}",q);
		}
	}
	@Test
	@Disabled
	void test3() {
		
		log.info("{}",matchService.findRecentMatch());
	}
	
	@Test
	@Disabled
	void test4() {
		
	}
}

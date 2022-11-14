package soccer.deploy;
import java.util.List;

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
import soccer.deploy.user.repository.UserRepository;
import soccer.deploy.user.service.UserService;

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
	@Autowired
	private UserService userService;
	
	@Test
	@Disabled
	void test1(){
		for(Entry e :entryService.findEntryRecentMatch(1L)){
			
			log.info("{}",e);
		}
	}
	@Test
	void test2() {
		log.info("{}",userService.searchEntryUsers(1L, "sa"));
	}
}

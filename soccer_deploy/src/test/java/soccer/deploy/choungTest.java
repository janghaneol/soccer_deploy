package soccer.deploy;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.MyEntry.EntryMyDao;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.repository.JpaMatchRepository;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.repository.JpaQuarterRepository;
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
	@Autowired
	private JpaEntryRepository entryRepository;
	@Autowired
	private JpaMatchRepository m;
	@Autowired
	private JpaQuarterRepository q;
	
	@Autowired
	private EntryMyDao entryMyDao;
	
	@Test
	@Disabled
	void test1(){
		for(Entry e :entryService.findEntryRecentMatch(1L)){
			
			log.info("test{}",entryMyDao.show("1").get(0));
		}
	}
	
	@Test
	void test3() {
//		log.info("{}",m.resultMatch("23/11").get(0).getCount());
//		log.info("{}",m.resultMatch("22/12").get(1).getWin());
	}
}

package soccer.deploy;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.entry.service.EntryService;
import soccer.deploy.lineUp.repository.JpaLineUpRepository;
import soccer.deploy.match.myService.MatchChoungService;
import soccer.deploy.match.repository.JpaMatchRepository;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.quarter.repository.JpaQuarterRepository;
import soccer.deploy.quarter.service.QuarterService;
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
	private JpaLineUpRepository l;
	@Autowired
	private MatchChoungService matchChoungService;
	
	@Test
	@Disabled
	void test1(){
		for(Entry e :entryService.findEntryRecentMatch(1L)){
			
//			log.info("test{}",entryMyDao.show("1").get(0));
		}
	}
	
	@Test
	void test3() throws ParseException {
		List<Long> list = new ArrayList();
		list.add(27L);
		list.add(1L);
		
	}
}

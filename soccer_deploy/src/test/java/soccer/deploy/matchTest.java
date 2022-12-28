package soccer.deploy;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.service.MatchService;
import soccer.deploy.user.service.UserService;

@SpringBootTest
@Slf4j
	
public class matchTest {

	@Autowired
	private matchDao MatchDao;
	@Autowired
	private JpaEntryRepository entryService;
	@Autowired
	private MatchService m;
	@Autowired
	UserService u;
	@Test
	public void matchTest() {
		Entry entry =new Entry();
		entry.setMatch(m.findeRecentMatch(10L));
		entry.setUser(u.findUser(1L).get());
		entryService.save(entry);
		
		log.info("{}",MatchDao.list());
	}
	
}

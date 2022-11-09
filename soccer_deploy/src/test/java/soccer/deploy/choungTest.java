package soccer.deploy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.entry.repository.JpaEntryRepository;

@SpringBootTest
@Transactional
@Slf4j
public class choungTest {
	@Autowired
	private JpaEntryRepository entryRepository;
	
	 void test1(){
		 entryRepository.findAll();
		 log.info("{}",entryRepository.findAll());
	}
}

package soccer.deploy;
import java.text.ParseException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.article.service.ArticleService;
import soccer.deploy.image.service.ImageService;
import soccer.deploy.quarter.service.QuarterService;

@SpringBootTest
@Transactional
@Slf4j
public class choungTest {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private QuarterService q;
	@Test
	@Disabled
	void test1(){
		
	}
	
	@Test
	void test3() throws ParseException {
	
//		log.info("{}",q.checkQuarter(27L));
	
	
		
	}
}

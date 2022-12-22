package soccer.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class HyodongkimApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyodongkimApplication.class, args);
	}
	
	/* @PutMapping 과 @DeleteMapping을 위해서 선언해줘야 되는 부분! */
	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
		return new HiddenHttpMethodFilter();
	}
	
}

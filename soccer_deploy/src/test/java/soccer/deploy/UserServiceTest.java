
package soccer.deploy;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;
import soccer.deploy.user.service.UserService;

@SpringBootTest

@Slf4j
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	@Disabled
	public void regist() {
		User user = new User();
		user.setEmail("jhano9@naver.com");
		user.setPasswd("123456");
		user.setAge(30);
		user.setName("�뼹");
		user.setAddress("寃쎄린�룄 �쓽�젙遺��떆");

		Long userId = userService.register(user);
		log.info("�벑濡앸맖 : {}", userId);
	}

	@Test
	public void login() { // User loginUser =
		userService.login("jhano9@naver.com", "123456");
		User loginUser = userRepository.findByEmailAndPasswd("jhano9@naver.com", "123456");
		log.info("濡쒓렇�씤�릺�뿀�뒿�땲�떎 : �쉶�썝 {}", loginUser.getName());
	}
}

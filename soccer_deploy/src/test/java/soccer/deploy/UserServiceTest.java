
package soccer.deploy;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.dto.UpdateUserDto;
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
	public void regist() {
		User user = new User();
		user.setEmail("Test2@Test.com3");
		user.setPasswd("test123456");
		user.setName("테스트2");
		user.setAge(20);
		user.setAddress("민락동");
		user.setPosition("MF");
		user.setBackNum(7);
		
		Long userId = userService.register(user);
		log.info("가입한 회원 : {}", userId);
	}

	@Test
	@Disabled
	public void login() { 
		User loginUser = userRepository.findByEmailAndPasswd("jhano9@naver.com", "123456");
		log.info("로그인 한 회원 정보 {}", loginUser);
	}
	
	@Test
	@Disabled
	public void userList() {
		List<User> allUser = userRepository.findAll();
		log.info("전체 회원 정보");
		for (User user : allUser) {
			log.info("{}",user);
		}	
	}
	
	@Test
	@Disabled
	public void findUser() {
		
		Long userId = 4L;
		Optional<User> optional = userService.findUser(userId);
		log.info("검색한 회원 정보 : {}",optional.get());
		
	}
	
	@Test
	@Disabled
	public void update() {
		
		Long userId = 5L;
		User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("해당회원이 없음."));
		user.setAddress("수정된 주소");
		user.setBackNum(99);
		user.setPosition("GK");
		
		log.info("수정된 회원 정보 : {}",user);
	}
	
	@Test
	@Disabled
	public void delete() {
		
		Long userId = 5L;	
		Optional<User> deleteuser = userRepository.findById(userId);
		deleteuser.ifPresent(selectUser ->{
			userRepository.delete(selectUser);
		});
		log.info("삭제된 회원 : {}", deleteuser);
	}
}

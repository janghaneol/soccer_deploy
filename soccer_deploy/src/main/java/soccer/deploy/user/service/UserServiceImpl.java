package soccer.deploy.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	
	@Transactional
	@Override
	public User login(String email, String passwd) {
		return userRepository.findByEmailAndPasswd(email, passwd);
	}
	
	@Transactional
	@Override
	public Long register(User user) {
		User saveUser = userRepository.save(user);
		return saveUser.getId();
	}



	

}

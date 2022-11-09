package soccer.deploy.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	public Long register(User user) {
		User registUser = userRepository.save(user);
		return registUser.getId();
	}

	
	
	@Override
	public User Login(String email, String passwd) {
		return userRepository.findByEmailAndPasswd(email, passwd);
	}



	
}

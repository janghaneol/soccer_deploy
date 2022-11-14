package soccer.deploy.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soccer.deploy.user.entity.User;
import soccer.deploy.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public Long register(User user) {
		User registUser = userRepository.save(user);
		return registUser.getId();
	}
	
	@Transactional
	@Override
	public User Login(String email, String passwd) {
		return userRepository.findByEmailAndPasswd(email, passwd);
	}

	@Override
	public List<User> searchEntryUsers(Long id, String name) {
		// TODO Auto-generated method stub
		return userRepository.findEntryUser(id, name);
	}

	

}

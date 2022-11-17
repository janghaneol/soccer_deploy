package soccer.deploy.user.service;

import java.util.List;
import java.util.Optional;

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
	public Long register(User user) {
		User saveUser = userRepository.save(user);
		return saveUser.getId();
	}
	
	@Override
	public User login(String email, String passwd) {
		return userRepository.findByEmailAndPasswd(email, passwd);
	}
	
	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUser(Long userId) {
		return userRepository.findById(userId);
	}

}

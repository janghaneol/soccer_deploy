package soccer.deploy.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.dto.UpdateUserDto;
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

	@Override
	public Page<User> searchUser(String name,Pageable pageable) {
		return userRepository.findAllByNameContaining(name, pageable);
	}

	@Transactional
	@Override
	public Long updateUser(Long userId, UpdateUserDto updateUser) {
		User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("해당 회원이 없습니다. id= "+userId));
		user.update(updateUser.getAddress(), updateUser.getImgContType(), updateUser.getImgFileName(), updateUser.getBackNum(), updateUser.getPosition());
		return user.getId();
	}
	
	@Transactional
	@Override
	public void delete(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("해당 회원은 존재하지 않습니다."));
		userRepository.delete(user);
	}

	@Override
	public void imgUpdate(Long userId, String profile) {
		Optional<User> user = userRepository.findById(userId);
		user.get().setImgFileName(profile);
		User updateProfile = user.get();
		userRepository.save(updateProfile);
	}

	@Override
	public int idCheck(String email) {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			return 1;
		}
		return 0;
	}
}

package soccer.deploy.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import soccer.deploy.user.entity.User;

public interface UserService {
	// 회원 가입
	public Long register(User user);
	
	// 로그인
	public User login(String email, String passwd);
	
	// 전체 회원 조회
	public List<User> list();
	
	// 회원 상세보기
	public Optional<User> findUser(Long userId);
}
	


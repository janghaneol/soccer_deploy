package soccer.deploy.user.service;

import java.util.List;

import soccer.deploy.user.entity.User;

public interface UserService {
	// 회원 가입
	public Long register(User user);
	// 로그인
	public User login(String email, String passwd);
}
	


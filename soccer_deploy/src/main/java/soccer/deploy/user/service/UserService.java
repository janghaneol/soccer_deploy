package soccer.deploy.user.service;

import soccer.deploy.user.entity.User;

public interface UserService {
	// 회원가입
	public Long register(User user);
	// 회원인증 (로그인)
	public User Login(String email, String passwd);
}

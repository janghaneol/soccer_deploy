package soccer.deploy.user.service;

import soccer.deploy.user.entity.User;

public interface UserService {
	
	/* 로그인 */
	public User login(String email, String password);
}

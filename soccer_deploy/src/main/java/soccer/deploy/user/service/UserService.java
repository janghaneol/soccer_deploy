package soccer.deploy.user.service;

import java.util.List;

import soccer.deploy.user.entity.User;

public interface UserService {
	// 占쎌돳占쎌뜚揶쏉옙占쎌뿯
	public Long register(User user);
	// 占쎌돳占쎌뜚占쎌뵥筌앾옙 (嚥≪뮄�젃占쎌뵥)
	public User Login(String email, String passwd);
}


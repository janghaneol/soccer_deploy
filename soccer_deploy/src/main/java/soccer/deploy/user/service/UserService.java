package soccer.deploy.user.service;

import java.util.List;

import soccer.deploy.user.entity.User;

public interface UserService {
	// �쉶�썝媛��엯
	public Long register(User user);
	// �쉶�썝�씤利� (濡쒓렇�씤)
	public User Login(String email, String passwd);
	


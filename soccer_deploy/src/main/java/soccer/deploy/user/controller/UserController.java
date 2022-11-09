package soccer.deploy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.user.service.UserService;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	
}
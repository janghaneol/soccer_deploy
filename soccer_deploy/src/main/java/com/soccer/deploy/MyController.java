package com.soccer.deploy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "contact";
	}
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/matches")
	public String matches() {
		
		return "matches";
	}
	
	@RequestMapping("/players")
	public String players() {
		
		return "players";
	}
	
	@RequestMapping("/single")
	public String single() {
		
		return "single";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		
		return "blog";
	}
	@RequestMapping("/mainPage")
	public String mainPage() {
		
		return "mainPage";
	}
	@RequestMapping("/xLogin")
	public String xLogin() {
		
		return "xLogin";
	}
	@RequestMapping("/xmain")
	public String xMain() {
		
		return "xMain";
	}
	

}

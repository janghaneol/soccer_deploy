package soccer.deploy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import soccer.deploy.dto.pageDTO;
import soccer.deploy.dao.noticeDAO;
import soccer.deploy.dao.pageDAO;
import soccer.deploy.dto.noticeDTO;
import soccer.deploy.dto.usersDTO;
import soccer.deploy.service.noticeService;
import soccer.deploy.service.pageService;
import soccer.deploy.service.usersService;

@Controller
public class MyController {

	@Autowired
	private usersService UsersService;

	@Autowired
	private noticeService NoticeService;

	@Autowired
	private pageService PageService;
	
	@Autowired
	private noticeDAO NoticeDAO;
	
	@Autowired
	private pageDAO PageDAO;

	@RequestMapping("/")
	public String index() {

		return "index";
	}

	@RequestMapping("/main")
	public String main() {

		return "view/main";
	}

	@RequestMapping("/contact")
	public String contact() {

		return "view/contact";
	}

	@RequestMapping("/matches")
	public String matches() {

		return "view/matches";
	}

	@RequestMapping("/players")
	public String players() {

		return "view/players";
	}

	@RequestMapping("/single")
	public String single() {

		return "view/single";
	}

	@RequestMapping("/blog")
	public String blog() {

		return "view/blog";
	}

	@RequestMapping("/mainPage")
	public String mainPage() {

		return "view/mainPage";
	}

	@RequestMapping("/login")
	public String login() {

		return "view/user/login";
	}

	@RequestMapping("/xMain")
	public String xMain() {

		return "view/xMain";
	}

	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}

	@GetMapping("/test")
	public String lineUp() {
		return "view/lineUp/lineUp";
	}

//	Mybatis분들은 이거 보면서 하면 도움이 될거예요!
	@RequestMapping("/users")
	public String users(Model model) {

		List<usersDTO> select = UsersService.select();
		model.addAttribute("select", select);

		return "users";
	}

	@RequestMapping("/notice")
	public String notice(Model model) {

		return "notice";
	}

	@RequestMapping("/xnotice")
	public String xnotice(Model model, @RequestParam("pagenum") int pagenum) {
		
//		List<noticeDTO> view_page_num = NoticeService.view_page_num();
		List<pageDTO> view_page_num = PageService.view_page_num();

		model.addAttribute("view_page_num", view_page_num);
		
		List<noticeDTO> view_content = NoticeService.view_content(pagenum);								

		model.addAttribute("view_content", view_content);
		
		
		
		
//		List<noticeDTO> select = NoticeService.select();
//
//		model.addAttribute("select", select);
//		
//		
//		  model.addAttribute("To_front_page_num",NoticeDAO.select());
//		  
//		  model.addAttribute("To_back_page_num",NoticeDAO.select());
		 

		return "xnotice";

	}
	
	@RequestMapping(value="/To_front_page_num", method=RequestMethod.GET)
	public String To_front_page_num(Model model, @RequestParam("pagenum") int pagenum
					) throws Exception {
		
					PageDAO.To_front_page_num(pagenum);
					
					List<noticeDTO> view_content = NoticeService.view_content(pagenum);								

					model.addAttribute("view_content", view_content);
		
					return "xnotice";
	}
	@RequestMapping(value="/To_back_page_num", method=RequestMethod.GET)
	public String To_back_page_num( Model model, @RequestParam("pagenum") int pagenum) throws Exception {
	
					PageDAO.To_back_page_num(pagenum);
					
					List<noticeDTO> view_content = NoticeService.view_content(pagenum);								

					model.addAttribute("view_content", view_content);
							
					return "xnotice";
					
	}		
}

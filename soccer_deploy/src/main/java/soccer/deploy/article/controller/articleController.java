package soccer.deploy.article.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.article.entity.article;
import soccer.deploy.article.repository.JpaArticleRepository;
import soccer.deploy.article.service.ArticleService;
import soccer.deploy.notice.service.NoticeService;
import soccer.deploy.user.dto.LoginForm;
import soccer.deploy.user.entity.User;
import soccer.deploy.user.service.UserService;
import soccer.deploy.notice.dto.*;
import soccer.deploy.match.entity.Match;

@Controller
@Slf4j
public class articleController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private JpaArticleRepository jpaArticleRepository;
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/realArticleAction")
	/* default page = 0, default size = 10 */
	public String reallistBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "articleId", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model, @RequestParam(required = false, defaultValue = "") String subject) {
		
		Page<article> page = articleService.findArticles(search, pageable);
		    	
		long totalElements = page.getTotalElements();
		
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list",articleService.findArticles(subject, pageable));
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realArticle";
	}
	@RequestMapping("/realArticle")
	public String realSearch(@PageableDefault(page = 0, size = 10, sort = "articleId", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model) {
	
		Page<article> page = articleService.findArticles(search, pageable);
		
		long totalElements = page.getTotalElements();	
		List<article> list = page.getContent();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list", list);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realArticle";
	}
	
	@RequestMapping("/{articleId}")
	/* default page = 0, default size = 10 */
	public String view(@PathVariable Integer articleId,HttpSession session, Model model,HttpServletRequest request, @ModelAttribute("Article") article Article) {
		
//		List<article> reply = articleService.findArticles();
//		model.addAttribute("reply", reply);
		
		Match registMatch = new Match();
		
		registMatch.setUser((User)session.getAttribute("loginUser"));
		
		List<Notice> reply = noticeService.showAll(articleId);
		model.addAttribute("reply", reply);
		
		Optional<article> optional = articleService.findArticle(articleId);
		model.addAttribute("list", optional.get());
		
		
		return "thymeleaf/intoArticle";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute Match match, Model model, HttpSession session, HttpServletRequest request) {
		
		return "thymeleaf/insert";
	}
	
	@GetMapping("/register")
	public String register(Model model, @RequestParam(required = false, defaultValue = "") String search,  @ModelAttribute("Article") article Article, @PageableDefault(page = 0, size = 10, sort = "articleId", direction = Sort.Direction.ASC) Pageable pageable) {
		
		articleService.register(Article);
		
		Page<article> page = articleService.findArticles(search, pageable);
		
		long totalElements = page.getTotalElements();	
		List<article> list = page.getContent();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();
		
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("list", list);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);
		
		return "thymeleaf/realArticle";
	}
	
	@GetMapping(value="/intoArticleAction")
	public String intoArticleAction(Model model,HttpSession session, HttpServletRequest request, @ModelAttribute("notice") Notice notice, @RequestParam("articleId") Integer articleId) throws Exception {
		
//		articleService.register(Article);
		
		Match registMatch = new Match();
		
		registMatch.setUser((User)session.getAttribute("loginUser"));
		
		noticeService.register(notice);
		
		Optional<article> optional = articleService.findArticle(articleId);
		model.addAttribute("list", optional.get());
				
		List<Notice> reply = noticeService.showAll(articleId);
		model.addAttribute("reply", reply);
		
		
		
		return "thymeleaf/intoArticle";
	}
}

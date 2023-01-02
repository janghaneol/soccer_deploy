//package soccer.deploy.board.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import lombok.extern.slf4j.Slf4j;
//import soccer.deploy.board.entity.board;
//import soccer.deploy.board.repository.JpaBoardRepository;
//import soccer.deploy.board.service.BoardService;
//
//@Controller
//@Slf4j
//public class boardController {
//	
//	
//	@Autowired
//	private BoardService boardService;
//	@Autowired
//	private JpaBoardRepository jpaBoardRepository;
//	
//	@GetMapping("/realBoardAction")
//	/* default page = 0, default size = 10 */
//	public String reallistBySearchAndPaging(@PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model, @RequestParam(required = false, defaultValue = "") String title) {
//		
//		Page<board> page = boardService.findBoards(search, pageable);
//		    	
//		long totalElements = page.getTotalElements();
//		
//		int requestPage = page.getPageable().getPageNumber() + 1;
//		int totalPage = page.getTotalPages();
//		int startPage = Math.max(1, requestPage - 4);
//		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
//		boolean hasPrevious = page.hasPrevious();
//		boolean hasNext = page.hasNext();
//		
//		model.addAttribute("totalElements", totalElements);
//		model.addAttribute("list",boardService.findBoards(title, pageable));
//		model.addAttribute("requestPage", requestPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("hasPrevious", hasPrevious);
//		model.addAttribute("hasNext", hasNext);
//		
//		return "thymeleaf/realBoard";
//	}
//	@RequestMapping("/realBoard")
//	public String realSearch(@PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.ASC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search,  Model model) {
//	
//		Page<board> page = boardService.findBoards(search, pageable);
//		
//		long totalElements = page.getTotalElements();	
//		List<board> list = page.getContent();
//		int requestPage = page.getPageable().getPageNumber() + 1;
//		int totalPage = page.getTotalPages();
//		int startPage = Math.max(1, requestPage - 4);
//		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
//		boolean hasPrevious = page.hasPrevious();
//		boolean hasNext = page.hasNext();
//		
//		model.addAttribute("totalElements", totalElements);
//		model.addAttribute("list", list);
//		model.addAttribute("requestPage", requestPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("hasPrevious", hasPrevious);
//		model.addAttribute("hasNext", hasNext);
//		
//		return "thymeleaf/realBoard";
//	}
//	
//	@GetMapping("/{boardId}")
//	/* default page = 0, default size = 10 */
//	public String view(@PathVariable int boardId, Model model) {
//		Optional<board> optional = boardService.findBoard(boardId);
//		model.addAttribute("list", optional.get());
//		return "thymeleaf/intoBoard";
//	}
//	
//	@RequestMapping("/insert")
//	public String insert(Model model) {
//		
//		return "thymeleaf/insert";
//	}
//	
//	@GetMapping("/register")
//	public String register(Model model, @RequestParam(required = false, defaultValue = "") String search,  @ModelAttribute("Board") board Board, @PageableDefault(page = 0, size = 10, sort = "boardId", direction = Sort.Direction.ASC) Pageable pageable) {
//		
//		boardService.register(Board);
//		
//		Page<board> page = boardService.findBoards(search, pageable);
//		
//		long totalElements = page.getTotalElements();	
//		List<board> list = page.getContent();
//		int requestPage = page.getPageable().getPageNumber() + 1;
//		int totalPage = page.getTotalPages();
//		int startPage = Math.max(1, requestPage - 4);
//		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
//		boolean hasPrevious = page.hasPrevious();
//		boolean hasNext = page.hasNext();
//		
//		model.addAttribute("totalElements", totalElements);
//		model.addAttribute("list", list);
//		model.addAttribute("requestPage", requestPage);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("hasPrevious", hasPrevious);
//		model.addAttribute("hasNext", hasNext);
//		
//		return "thymeleaf/realBoard";
//	}
//}

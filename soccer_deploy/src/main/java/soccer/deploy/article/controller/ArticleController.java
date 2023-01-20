package soccer.deploy.article.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.rowset.serial.SerialArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.article.dto.ArticleDto;
import soccer.deploy.article.entity.Article;
import soccer.deploy.article.service.ArticleService;
import soccer.deploy.image.entity.Image;
import soccer.deploy.image.service.ImageService;

@Controller
@Slf4j
@RequestMapping("/board")
public class ArticleController {
	
	@Value("${spring.servlet.multipart.location}") // location 안에 값이 들어감 EL사용
	private String location;
	@Autowired
	private ImageService imageService;
		
	@Autowired
	private ArticleService articleService;
	
	//등록화면
	@GetMapping("/{boardId}/article/write")
	public String RegistViewArticle(@PathVariable Long boardId, Model model) {
		model.addAttribute("boardId", boardId);
		return "view/board/boardReg";
	}
	
	
	@PostMapping("/{boardId}/article/write")
	public String RegistArticle(RedirectAttributes redirectAttributes,@PathVariable Long boardId, @ModelAttribute("article") Article article, @RequestParam MultipartFile[] uploadFiles) throws Exception {
		log.info("test{}",article);
		List<Image> list = new ArrayList<>();
		article = articleService.RegArticleNextPk(article);
		for (MultipartFile file : uploadFiles) {
			if (!file.isEmpty()) {
				String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
				Image fi = new Image(article, file.getContentType(),fileName);
				list.add(fi);
				file.transferTo(new File(fileName)); // 이 한줄이면 업로드가능 위에는 디비 저장하기 위해
			}
		}
		imageService.RegImage(list);

		redirectAttributes.addAttribute("boardId", boardId);
		redirectAttributes.addAttribute("groupNo", article.getArticleId());
		return "redirect:/board/{boardId}/article/{groupNo}";
	}
	
	//게시글 뷰
		@GetMapping("/{boardId}/article/{groupNo}")
		public String ViewArticle(@PathVariable Long boardId, @PathVariable Long groupNo,Model model,@RequestParam(required = false,defaultValue = "")String searchValue) {
		List<ArticleDto> artic = articleService.prevNext(boardId, groupNo,searchValue);
			if(artic.size() == 1) {
				model.addAttribute("bool",true);
			}else {
				model.addAttribute("bool",false);
			}
			log.info("artic{}",artic);
			model.addAttribute("prevNext",artic);
			model.addAttribute("images",imageService.findImgArticle(groupNo));
			model.addAttribute("articles",articleService.detailArticle(boardId, groupNo));
			return "view/board/boardView";
		}
		//댓글 작성
		@PostMapping("/{boardId}/article/{groupNo}/dat")
		public String RegDat(RedirectAttributes redirectAttributes,@PathVariable Long boardId, @PathVariable Long groupNo,@ModelAttribute("article") Article article,@RequestParam(defaultValue ="",required = false )String searchValue) {
			articleService.RegDatArticle(article);
			redirectAttributes.addAttribute("boardId", boardId);
			redirectAttributes.addAttribute("groupNo", groupNo);
			return "redirect:/board/{boardId}/article/{groupNo}?searchValue="+searchValue;
		}
		//대댓글
		@PostMapping("/{boardId}/article/{groupNo}")
		public String RegDaDat(RedirectAttributes redirectAttributes,@PathVariable Long boardId, @PathVariable Long groupNo,@ModelAttribute("article") Article article,@RequestParam(defaultValue ="",required = false )String searchValue) {
			articleService.RegDaDatArticle(article);
			redirectAttributes.addAttribute("boardId", boardId);
			redirectAttributes.addAttribute("groupNo", groupNo);
			return "redirect:/board/{boardId}/article/{groupNo}?searchValue=" +searchValue;
		}
		@GetMapping("/{boardId}/article")
		public String ListArticle(@PathVariable Long boardId,@PageableDefault(size=10,page=0,sort = "articleId" ,direction =Sort.Direction.DESC )Pageable pageable,@RequestParam(required = false,defaultValue = "")String searchValue , Model model) {
			int startPage;
			int endPage;
			Page<Article> pageResult = articleService.findPageArticle(boardId, searchValue, pageable);
			int pageList = pageResult.getNumber()/10;
			startPage = (pageList * 10);
			endPage = (pageList * 10) + 10 - 1;
			if(endPage > pageResult.getTotalPages() - 1) { 
				endPage = pageResult.getTotalPages() - 1;
			}
			log.info("search{}",searchValue);
			log.info("page{}",pageResult.getContent());
			model.addAttribute("boardId",boardId);
			model.addAttribute("pageResults",pageResult);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			return "view/board/boardList";
		}
}

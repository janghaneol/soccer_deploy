package soccer.deploy.article.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import soccer.deploy.article.entity.article;

public interface ArticleService {
	
	/* 게시판등록 */
	public int register(article Article);
	
	/** 게시판 인증 */
	public article isArticle(String writer, String subject, String content);
	
	/** 게시판 상세 */
	public Optional<article> findArticle(int articleId);

	/** 전체 게시판 조회 */
	public List<article> findArticles();
	
	/** 검색, 페이징 처리 회원 조회 */
	public Page<article> findArticles(String searchValue, Pageable pageable);

}

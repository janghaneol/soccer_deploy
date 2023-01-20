package soccer.deploy.article.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import soccer.deploy.article.dto.ArticleDto;
import soccer.deploy.article.entity.Article;

public interface ArticleService {
	public void RegDatArticle(Article article);
	public void RegDaDatArticle(Article article);
	public Article RegArticleNextPk(Article article);
	
	public Page<Article> findPageArticle(Long boardId,String searchValue,Pageable pageable);
	
	public List<Article> detailArticle(Long boardId,Long groupNo);
	
	public List<ArticleDto> prevNext(Long boardId,Long groupNo, String searchValue);
}

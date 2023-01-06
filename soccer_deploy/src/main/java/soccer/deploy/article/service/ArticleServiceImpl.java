package soccer.deploy.article.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.article.entity.article;
import soccer.deploy.article.repository.JpaArticleRepository;

@Slf4j
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private JpaArticleRepository jpaArticleRepository;
	
//	@Override
//	public String register(article Article) {
//		article saveArticle = jpaArticleRepository.save(Article);
//		return saveArticle.getWriter();
//	}
	@Override
	public void register(article Article) {
		jpaArticleRepository.save(Article);
	}
	
	@Override
	public article insertReply(article Article){
		return jpaArticleRepository.save(Article);
	}

	@Override
	@Transactional(readOnly = true)
	public article isArticle(String writer, String subject, String content) {
		return jpaArticleRepository.findByWriterAndSubjectAndContent(writer, subject, content);
	}

	@Override
	public Optional<article> findArticle(Integer articleId) {
		return jpaArticleRepository.findByArticleId(articleId);
	}
	
	@Override
	public List<article> findArticles() {
		return jpaArticleRepository.findAll();
	}

	@Override
	public Page<article> findArticles(String searchValue, Pageable pageable) {
		return jpaArticleRepository.findAllByWriterOrSubjectContainingOrContentContaining(searchValue, searchValue, searchValue, pageable);
	}
	
}

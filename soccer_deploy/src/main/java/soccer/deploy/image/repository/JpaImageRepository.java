package soccer.deploy.image.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.article.entity.Article;
import soccer.deploy.image.entity.Image;

public interface JpaImageRepository extends JpaRepository<Image, Long> {
	
	@Query(value="SELECT i FROM Image i WHERE i.article.articleId = :article")
	public List<Image> findByArticle(@Param("article") Long articleId);
	
}

package soccer.deploy.article.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soccer.deploy.article.entity.article;

@Repository
public interface JpaArticleRepository extends JpaRepository<article, String>{
	// 게시판 작성자, 제목, 내용에 의한 조회
	public article findByWriterAndSubjectAndContent(String writer, String subject, String content);
	
	// 게시판 작성자 또는 제목 또는 내용에 의한 검색 - 목록 페이징 처리
	public Page<article> findAllByWriterOrSubjectContainingOrContentContaining(String writer, String subject, String content ,Pageable pageable);
	
	public Optional<article> findByArticleId(int articleId);
	
	public Optional<article> findByArticleIdAndWriterAndContentAndRegdate(int articleId, String writer, String content, String regdate);
	
	public Optional<article> findByWriter(String writer);
	

}
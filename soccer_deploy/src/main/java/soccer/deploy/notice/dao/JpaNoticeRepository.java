package soccer.deploy.notice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soccer.deploy.notice.dto.Notice;

@Repository
public interface JpaNoticeRepository extends JpaRepository<Notice, String>{
//	// 아이디와 비밀번호에 의한 조회
//	public Notice findByIdAndTitle(String id, String title);
//	
//	// 아이디 또는 이름에 의한 검색 - 목록 페이징 처리
//	public Page<Notice> findAllByIdOrTitleContaining(String id, String title, Pageable pageable);
//	
//	public Optional<Notice> findByNum(int num);
	
	public List<Notice> findByArticleId(Integer articleId);
}
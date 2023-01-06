package soccer.deploy.notice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import soccer.deploy.notice.dto.Notice;

public interface NoticeService {
	
//	/* 공지등록 */
	public void register(Notice notice);
//	
//	/** 회원 인증 */
//	public Notice isNotice(String id, String title);
//	
//	/** 회원 상세 */
//	public Optional<Notice> findNotice(int num);
//
//	/** 전체 회원 조회 */
//	public List<Notice> findNotices();
//	
//	/** 검색, 페이징 처리 회원 조회 */
//	public Page<Notice> findNotices(String searchValue, Pageable pageable);
	
	public List<Notice> showAll(Integer articleId);
	
}

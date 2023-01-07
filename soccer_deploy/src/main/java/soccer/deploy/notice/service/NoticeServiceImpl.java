package soccer.deploy.notice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.notice.dao.JpaNoticeRepository;
import soccer.deploy.notice.dto.Notice;

@Slf4j
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private JpaNoticeRepository jpaNoticeRepository;
//	
	@Override
	public void register(Notice notice) {
		jpaNoticeRepository.save(notice);
	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Notice isNotice(String id, String title) {
//		return jpaNoticeRepository.findByIdAndTitle(id, title);
//	}
//
//	@Override
//	public Optional<Notice> findNotice(int num) {
//		return jpaNoticeRepository.findByNum(num);
//	}
//	
//	@Override
//	public List<Notice> findNotices() {
//		return jpaNoticeRepository.findAll();
//	}
//
//	@Override
//	public Page<Notice> findNotices(String searchValue, Pageable pageable) {
//		return jpaNoticeRepository.findAllByIdOrTitleContaining(searchValue, searchValue, pageable);
//	}
	
	@Override
	public List<Notice> showAll(Integer articleId){
		return jpaNoticeRepository.findByArticleId(articleId);
		
	}
}

package soccer.deploy.entry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {
	@Autowired
	private JpaEntryRepository jpaentryRepository;

	@Override //최신 경기일정에 해당하는 선수들 가져오기
	public List<Entry> findEntryRecentMatch(Long id) {
		return jpaentryRepository.findAllByMatchId(2L);
	
	}
}

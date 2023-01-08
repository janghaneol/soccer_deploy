package soccer.deploy.quarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.quarter.entity.Quarter;
import soccer.deploy.quarter.repository.JpaQuarterRepository;

@Service
@Transactional
public class QuarterServiceImpl implements QuarterService {
	@Autowired
	private JpaQuarterRepository jpaQuarterRepository;

	@Override //최신 경기 쿼터정보 가져오기
	public List<Quarter> findQuarterRecentMatch(Long id) {
		
		return jpaQuarterRepository.findAllByMatchId(id,Sort.by("id"));
	}
	
	
}

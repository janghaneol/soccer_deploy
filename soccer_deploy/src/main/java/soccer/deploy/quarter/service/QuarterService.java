package soccer.deploy.quarter.service;

import java.util.List;

import soccer.deploy.quarter.entity.Quarter;

public interface QuarterService {
	//최신 경기 쿼터정보 가져오기
	List<Quarter> findQuarterRecentMatch(Long id);
}

package soccer.deploy.quarter.service;

import java.util.List;

import soccer.deploy.lineUp.entity.LineUp;
import soccer.deploy.quarter.entity.Quarter;

public interface QuarterService {
	//�ֽ� ��� �������� ��������
	public List<Quarter> findQuarterRecentMatch(Long id);
	
	public void updateInsertQuarter(List<Quarter> outcome);
	
	public void registQuarter(List<Quarter> quarter);
	
	public List<Long> checkQuarter(Long matchId ,List<LineUp> lineUp);
}

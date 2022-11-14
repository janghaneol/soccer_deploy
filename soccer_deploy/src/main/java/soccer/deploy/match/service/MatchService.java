package soccer.deploy.match.service;

import soccer.deploy.match.entity.Match;

public interface MatchService {
	//최신 매치id정보 가지고오기
	public Long findRecentMatchNum();
	
	//최신 경기
	public Match findeRecentMatch(Long id);
}

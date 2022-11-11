package soccer.deploy.match.service;

import soccer.deploy.match.entity.Match;

public interface MatchService {
	//최신 매치정보 가지고오기
	public Long findRecentMatch();
}

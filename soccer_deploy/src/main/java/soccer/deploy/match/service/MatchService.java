package soccer.deploy.match.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import soccer.deploy.match.entity.Match;
import soccer.deploy.quarter.entity.Quarter;


public interface MatchService {
	public Long findRecentMatchNum();
	
	/* Match 조회 */
	public Match findeRecentMatch(Long id);
	
	/* Match 등록 */
	public Long registMatch(Match match);
	
	/* Match 삭제 */
	public void deleteMatch(Long id);
	
	/* Match 수정 */
	public Long modifyMatch(Long id, Match updateMatch);
	
	public List<Match> findMatchdate(String matchDate);
	
	public List<String> matchYear();
	
	public String month();
	
	public List<Match> findMatch(String year , String month);
	
	/* 등록된 가장 최신 매치의 id*/
	public Long findRecentViewMatch();
	
}

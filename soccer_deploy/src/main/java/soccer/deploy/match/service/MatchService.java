package soccer.deploy.match.service;

import soccer.deploy.match.entity.Match;


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
	
}

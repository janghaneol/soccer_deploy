package soccer.deploy.match.myService;

import java.util.HashMap;
import java.util.List;

import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDto.MatchDto;
import soccer.deploy.match.myDto.rank;

public interface MatchChoungService {
	public List<rank> rank(String year, String month);
	
	public List<String> year();
	public String month();
	
	public List<MatchDto> matchResult(String year, String month);
	
	public List<Long> findRecentTwoResultMatchId();
	
	public HashMap<String,MatchDto> recentTwoMatchResult(List<Long> id);

	
	public HashMap<String,List<rank>> recentTwoMatchPlayer(List<Long> id);
}

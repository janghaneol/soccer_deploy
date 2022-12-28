package soccer.deploy.match.myService;

import java.util.List;
import java.util.Map;

import soccer.deploy.match.myDto.rank;

public interface MatchChoungService {
	public List<rank> rank(String year, String month);
	
	public List<String> year();
	public String month();
	
}

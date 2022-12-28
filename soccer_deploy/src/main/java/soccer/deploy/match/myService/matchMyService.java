package soccer.deploy.match.myService;

import java.util.List;

import soccer.deploy.match.myDto.matchMyDto;

public interface matchMyService{

	public List<matchMyDto> list();
	
	public void matchRegist(matchMyDto MatchMyDto);
}

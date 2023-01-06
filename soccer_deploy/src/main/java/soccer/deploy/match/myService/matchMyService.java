package soccer.deploy.match.myService;

import java.util.List;
import java.util.Map;

import soccer.deploy.match.myDto.matchMyDto;

public interface matchMyService{

	/* 경기목록조회 */
	public List<matchMyDto> list();
	
	/* 경기등록 */
	public void matchRegist(matchMyDto MatchMyDto);
	
//	/* 경기수정 */
//	public void matchUpdate(matchMyDto MatchMyDto);
//	
//	/* 경기삭제 */
//	public void matchDelete(matchMyDto MatchMyDto);
	
	/* 경기이름으로 조회 */
	public matchMyDto selectMatch(int matchId);
	
}

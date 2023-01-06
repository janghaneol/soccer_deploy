package soccer.deploy.match.myDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDto.matchMyDto;

//@Mapper : 인터페이스 함수와 mybatis 연결 
@Mapper
public interface matchDao {

	/* 경기목록조회 */
	public List<matchMyDto> list();

	/* 경기등록 */
	public void matchRegist(matchMyDto MatchMyDto);

	/* 경기수정 */
	public void matchUpdate(matchMyDto MatchMyDto);

	/* 경기삭제 */
	public void matchDelete(matchMyDto MatchMyDto);

	/* 경기이름으로 조회 */
	public matchMyDto selectMatch(int matchId);


}

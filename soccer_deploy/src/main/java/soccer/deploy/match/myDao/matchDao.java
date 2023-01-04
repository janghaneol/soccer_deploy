package soccer.deploy.match.myDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.match.myDto.matchMyDto;
import soccer.deploy.match.myDto.rank;

//@Mapper : �씤�꽣�럹�씠�뒪 �븿�닔�� mybatis �뿰寃� 
@Mapper
public interface matchDao {
	
	/* 寃쎄린紐⑸줉議고쉶 */
//	public List<matchMyDto> list();	
	
	/* 寃쎄린�벑濡� */
	public void matchRegist(matchMyDto MatchMyDto);
	
	/* 寃쎄린�닔�젙 */
	public void matchUpdate(matchMyDto MatchMyDto);
	
	/* 寃쎄린�궘�젣 */
	public void matchDelete(matchMyDto MatchMyDto);
	
	/* 寃쎄린�씠由꾩쑝濡� 議고쉶 */
	public matchMyDto selectMatch(String matchId);
	
	public List<matchMyDto> list();	
	
	public List<rank> rank(String date);
	
	public String date();
	
	public List<String> year();
	
	public List<String> matchYear();
	
	public String matchDate();
	
	public String matchFirst();
	
}

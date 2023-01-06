package soccer.deploy.match.myDao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.match.myDto.matchMyDto;
import soccer.deploy.match.myDto.rank;

//@Mapper : �씤�꽣�럹�씠�뒪 �븿�닔�� mybatis �뿰寃� 
@Mapper
public interface matchDao {
<<<<<<< HEAD

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


=======
	
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
	
>>>>>>> 4e6bdc3b3eb82afcd5a56f5b3b7e0cbb062ca424
}

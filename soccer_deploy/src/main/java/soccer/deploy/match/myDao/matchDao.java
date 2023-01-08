package soccer.deploy.match.myDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.match.myDto.matchMyDto;

//@Mapper : 인터페이스 함수와 mybatis 연결 
@Mapper
public interface matchDao {

	public List<matchMyDto> list();	
	
}

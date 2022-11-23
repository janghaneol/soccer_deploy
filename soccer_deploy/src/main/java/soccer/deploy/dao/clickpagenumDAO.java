package soccer.deploy.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface clickpagenumDAO {

	int To_front_page_num();

	int To_back_page_num();
	
	

}

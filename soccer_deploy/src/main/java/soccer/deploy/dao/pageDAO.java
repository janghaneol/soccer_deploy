package soccer.deploy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import soccer.deploy.dto.noticeDTO;
import soccer.deploy.dto.pageDTO;

@Mapper
public interface pageDAO {
	
	public List<pageDTO> view_page_num(int pagenum);
	
}

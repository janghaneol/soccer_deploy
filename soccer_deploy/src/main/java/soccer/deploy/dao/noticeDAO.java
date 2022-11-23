package soccer.deploy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.dto.pageDTO;
import soccer.deploy.dto.noticeDTO;

@Mapper
public interface noticeDAO {

	public List<noticeDTO> view_content(int notice_index);


}

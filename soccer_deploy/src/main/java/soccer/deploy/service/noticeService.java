package soccer.deploy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soccer.deploy.dao.noticeDAO;
import soccer.deploy.dto.noticeDTO;

@Component
public class noticeService {
	
	@Autowired
	private noticeDAO NoticeDAO;
	
	public List<noticeDTO> select(){
	List<noticeDTO> select = NoticeDAO.select();
	return select;
	}
}

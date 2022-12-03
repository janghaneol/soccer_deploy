package soccer.deploy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soccer.deploy.dao.noticeDAO;
import soccer.deploy.dao.pageDAO;
import soccer.deploy.dto.pageDTO;
import soccer.deploy.dto.Params;
import soccer.deploy.dto.noticeDTO;

@Component
public interface noticeService {
	public void registUser(noticeDTO NoticeDTO);
	public List<noticeDTO> listAll();
	public noticeDTO findById(String id);
	public noticeDTO login(String id, String passwd);
	public List<noticeDTO> search(String searchType, String searchValue);
	public int searchCount(String searchType, String searchValue);
	
	public List<noticeDTO> search(Params params);
}

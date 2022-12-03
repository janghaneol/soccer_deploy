package soccer.deploy.service;

import java.util.List;

import soccer.deploy.dao.noticeDAO;
import soccer.deploy.dto.Params;
import soccer.deploy.dto.noticeDTO;

public class noticeServiceImpl implements noticeService {
	
//	UserDao userDao = new JdbcUserDao();
	noticeDAO NoticeDAO;
	
	public noticeServiceImpl(noticeDAO NoticeDAO) {
		this.NoticeDAO = NoticeDAO;
	}
	
	@Override
	public void registUser(noticeDTO NoticeDTO){
		NoticeDAO.create(NoticeDTO);
	}

	@Override
	public List<noticeDTO> listAll() {
		return NoticeDAO.findAll();
	}

	@Override
	public noticeDTO findById(String id) {
		return NoticeDAO.findById(id);
	}

	@Override
	public noticeDTO login(String id, String passwd) {
		return NoticeDAO.findByIdAndPasswd(id, passwd);
	}

	@Override
	public List<noticeDTO> search(String searchType, String searchValue) {
		if(searchType.equalsIgnoreCase("name")) {
			searchValue = "%" + searchValue + "%";
		}
		return NoticeDAO.findAllBySearchOption(searchType, searchValue);
	}

	@Override
	public int searchCount(String type, String value) {
		if(type.equalsIgnoreCase("name")) {
			value = "%" + value + "%";
		}
		return NoticeDAO.countBySearchOption(type, value);
	}

	@Override
	public List<noticeDTO> search(Params params) {
		if(params.getSearchType().equalsIgnoreCase("name")) {
			params.setSearchValue("%" + params.getSearchValue() + "%");
		}
		return NoticeDAO.findAllBySearchOption(params);
	}
}
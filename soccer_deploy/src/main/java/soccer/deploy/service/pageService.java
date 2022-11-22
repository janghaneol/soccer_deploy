package soccer.deploy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soccer.deploy.dao.pageDAO;
import soccer.deploy.dto.noticeDTO;
import soccer.deploy.dto.pageDTO;

@Component
public class pageService {
	
	@Autowired
	private pageDAO PageDAO;

	public List<pageDTO> view_page_num() {
		
		List<pageDTO> view_page_num = PageDAO.view_page_num();
		
		return view_page_num;
	}

	
}

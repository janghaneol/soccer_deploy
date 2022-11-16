package soccer.deploy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import soccer.deploy.dao.usersDAO;
import soccer.deploy.dto.usersDTO;

@Component
public class usersService {
	
	@Autowired
	private usersDAO UsersDAO;
	
	public List<usersDTO> select() {
		  List<usersDTO> select = UsersDAO.select();
		  return select;
	  }

}

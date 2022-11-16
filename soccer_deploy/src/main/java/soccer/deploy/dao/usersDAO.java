package soccer.deploy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.dto.usersDTO;

@Mapper
public interface usersDAO {

	public List<usersDTO> select();
}
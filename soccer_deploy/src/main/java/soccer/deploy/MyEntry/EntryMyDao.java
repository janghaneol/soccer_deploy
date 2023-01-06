package soccer.deploy.MyEntry;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import soccer.deploy.MyUser.UserMyDto;
import soccer.deploy.user.entity.User;

@Mapper
public interface EntryMyDao {

	public List<UserMyDto> show();
	
}

package soccer.deploy.MyEntry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soccer.deploy.MyUser.UserMyDto;
import soccer.deploy.user.entity.User;

@Service
public class EntryMyService {
	
	@Autowired
	private EntryMyDao entryMyDao;
	
	
	public List<UserMyDto> show(Long matchId){
		List<UserMyDto> show = entryMyDao.show(matchId);
		return show;
	}

}
//public List<BookListDto> booklist() {
//	  List<BookListDto> booklist = BookListDao.booklist();
//	  
//	  return booklist;
//}
package soccer.deploy.match.myService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.matchMyDto;
import soccer.deploy.user.service.UserService;

@Service
@Transactional
public class matchMyServiceImpl implements matchMyService{
	@Autowired
	private matchDao dao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JpaEntryRepository entry;
	
	
	@Override
	public List<matchMyDto> list() {
		
		return dao.list();
	}

	@Override
	public void matchRegist(matchMyDto MatchMyDto) {
		dao.matchRegist(MatchMyDto);
		
	}
	
	public matchMyDto selectMatch(int matchId) {
		
		return dao.selectMatch(matchId);
	}


}

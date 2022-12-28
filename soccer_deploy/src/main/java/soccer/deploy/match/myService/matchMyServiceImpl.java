package soccer.deploy.match.myService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.matchMyDto;
@Service
@Transactional
public class matchMyServiceImpl implements matchMyService{
	@Autowired
	private matchDao dao;
	
	@Override
	public List<matchMyDto> list() {
		
		return dao.list();
	}

	@Override
	public void matchRegist(matchMyDto MatchMyDto) {
		dao.matchRegist(MatchMyDto);
	}
	
}

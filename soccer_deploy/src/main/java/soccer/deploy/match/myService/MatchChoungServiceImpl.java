package soccer.deploy.match.myService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.myDto.rank;

@Service
@Transactional
@Slf4j
public class MatchChoungServiceImpl implements MatchChoungService{
	@Autowired
	private matchDao dao;

	@Override
	public List<rank> rank(String year, String month) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter;
		String formatedNow;
		if(year.equals("first") && month.equals("first") ) {
			formatedNow = dao.date();
			return dao.rank(formatedNow);
		}else if(year.equals("first") && !month.equals("first")) {
			formatter = DateTimeFormatter.ofPattern("yy/");
			formatedNow = now.format(formatter);	
			formatedNow.concat(month);
			
			return dao.rank(formatedNow.concat(month));
		}else if(!year.equals("first") && month.equals("first")) {
			formatter = DateTimeFormatter.ofPattern("/MM");
			formatedNow = now.format(formatter);	
			return dao.rank(year.concat(formatedNow));
		}else {
			return dao.rank(year.concat("/").concat(month));
		}
	}

	@Override
	public List<String> year() {
		
		return dao.year();
	}
	public String month() {
		return dao.date().split("/")[1]; 
	}

	


}	

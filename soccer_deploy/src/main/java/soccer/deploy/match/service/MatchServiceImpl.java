package soccer.deploy.match.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.match.entity.Match;
import soccer.deploy.match.myDao.matchDao;
import soccer.deploy.match.repository.JpaMatchRepository;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {

	@Autowired
	private JpaMatchRepository jpaMatchRepository; 
	@Autowired
	private matchDao matchDao;
	@Override
	public Long findRecentMatchNum() {
		
		return  jpaMatchRepository.recentMatchNum();

	}

	@Override
	public Match findeRecentMatch(Long id) {
		Optional<Match> optional = jpaMatchRepository.recentMatch(id);
		if(optional.isEmpty()) {
			throw new RuntimeException(id+"등록된 매치가 없습니다.");
		}
		return optional.get();
	}
	
	/*
	 * 생성, 수정, 삭제는 Transaction관리를 해줘야됩니다!
	 */
	@Override
	@Transactional
	public Long registMatch(Match match) {
		Match regMatch = jpaMatchRepository.save(match);
		return regMatch.getId();
	}

	@Override
	@Transactional
	public void deleteMatch(Long id) {
		Optional<Match> findMatch = jpaMatchRepository.findById(id);
		if(findMatch.isEmpty()) {
			throw new RuntimeException(id + "로 등록된 매치가 없습니다.");
		}
		Match deleteMatch = findMatch.get();
		jpaMatchRepository.delete(deleteMatch);
	}

	@Override
	@Transactional
	public Long modifyMatch(Long id, Match updateMatch) {
		Optional<Match> findMatch = jpaMatchRepository.findById(id);
		if(findMatch.isEmpty()) {
			throw new RuntimeException(id + "로 등록된 매치가 없습니다.");
		}
		Match modMatch = findMatch.get();
		modMatch.setMatchDate(updateMatch.getMatchDate());
		modMatch.setMatchPlace(updateMatch.getMatchPlace());
		modMatch.setOpteam(updateMatch.getOpteam());
		modMatch.setMatchImgName(updateMatch.getMatchImgName());
		return modMatch.getId();
	}

	@Override
	public List<Match> findMatchdate(String matchDate) {
//		Optional<Match> match= jpaMatchRepository.findAllByMatchDate(matchDate);
//		if(match.isEmpty()) {
//			throw new RuntimeException(matchDate+"등록된 매치가 없습니다.");
//		}
		return jpaMatchRepository.findAllByMatchDate(matchDate);
	}

	@Override
	public List<Match> findMatch(String year, String month) {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter;
		String formatedNow;
		if(year.equals("first") && month.equals("first") ) {
			formatedNow = matchDao.matchDate();
			return jpaMatchRepository.findAllByMatchDate(formatedNow);
			
		}else if(year.equals("first") && !month.equals("first")) {
			formatter = DateTimeFormatter.ofPattern("yy/");
			formatedNow = now.format(formatter);
//			formatedNow = matchDao.matchFirst();
			return jpaMatchRepository.findAllByMatchDate(formatedNow.concat(month));
			
		}else if(!year.equals("first") && month.equals("first")) {
			formatter = DateTimeFormatter.ofPattern("/MM");
			formatedNow = now.format(formatter);	
			return jpaMatchRepository.findAllByMatchDate(year.concat(formatedNow));
			
		}else {
			return jpaMatchRepository.findAllByMatchDate(year.concat("/").concat(month));
		}
	}

	@Override
	public List<String> matchYear() {
		return matchDao.matchYear();
	}

	@Override
	public String month() {
		return matchDao.matchDate().split("/")[1];
	}

	@Override
	public Long findRecentViewMatch() {
		return jpaMatchRepository.recentViewMatch();
	}

}

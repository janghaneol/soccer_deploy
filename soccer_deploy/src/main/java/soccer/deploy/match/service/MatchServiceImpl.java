package soccer.deploy.match.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.match.entity.Match;
import soccer.deploy.match.repository.JpaMatchRepository;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {

	@Autowired
	private JpaMatchRepository jpaMatchRepository; 
	
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

}

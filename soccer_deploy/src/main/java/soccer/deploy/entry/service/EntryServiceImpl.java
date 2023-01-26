package soccer.deploy.entry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.entry.repository.JpaEntryRepository;
import soccer.deploy.match.entity.Match;
import soccer.deploy.user.entity.User;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {
	@Autowired
	private JpaEntryRepository jpaentryRepository;

	@Override // 최신 경기일정에 해당하는 선수들 가져오기
	public List<Entry> findEntryRecentMatch(Long id) {
		return jpaentryRepository.findAllByMatchId(id);
	}

	@Override
	public List<Entry> SearchRecentEntry(Long id, String name) {
		return jpaentryRepository.findSearchEntry(id, name);
	}

	@Override
	public List<Boolean> findUserAndEntryByMatch(List<Match> match, User user) {
		List<Boolean> boolList = new ArrayList<Boolean>();
		Boolean bool = null;
		for (Match match2 : match) {
			List<Entry> entry = jpaentryRepository.findAllByMatchId(match2.getId());
			for (Entry e : entry) {
				if(e.getUser().equals(user)) {
					bool = true;
					break;
				}
				bool = e.getUser().equals(user);
			}
			boolList.add(bool);
		}
		return boolList;
	}

}

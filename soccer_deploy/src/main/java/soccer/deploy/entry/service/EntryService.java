package soccer.deploy.entry.service;

import java.util.List;
import java.util.Optional;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.match.entity.Match;
import soccer.deploy.user.entity.User;

public interface EntryService {
	//�ֽ� ��ġ ��Ʈ�� ��������
	public List<Entry> findEntryRecentMatch(Long id);
	
	public List<Entry> SearchRecentEntry(Long id, String name);
	
	public List<Boolean> findUserAndEntryByMatch(List<Match> match, User user);
	
	public Boolean indexMatch(Match match , User user);
	
	public void deleteEntry(Long id, User user);
	
}

package soccer.deploy.entry.service;

import java.util.List;

import soccer.deploy.entry.entity.Entry;

public interface EntryService {
	//최신 매치 엔트리 가져오기
	public List<Entry> findEntryRecentMatch(Long id);
	
	
}

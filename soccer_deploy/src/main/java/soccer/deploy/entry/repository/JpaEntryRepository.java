package soccer.deploy.entry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.entry.entity.Entry;

public interface JpaEntryRepository extends JpaRepository<Entry, Long> {
	List<Entry> findAllByMatchId(Long Id);
	
	@Query(value="SELECT  e from Entry e join e.user u where e.match.id = :id and LOWER(u.name) like LOWER(concat('%',:name,'%'))")
	List<Entry> findSearchEntry(@Param("id") Long id , @Param("name") String name);
	 
}

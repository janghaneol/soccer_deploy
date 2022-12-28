package soccer.deploy.entry.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.entry.entity.Entry;

public interface JpaEntryRepository extends JpaRepository<Entry, Long> {
	List<Entry> findAllByMatchId(Long Id);
	
	@Query(value="SELECT  e from Entry e join e.user u where e.match.id = :id and LOWER(u.name) like LOWER(concat('%',:name,'%'))")
	List<Entry> findSearchEntry(@Param("id") Long id , @Param("name") String name);
	 
	@Modifying
	@Transactional
	@Query(value="INSERT INTO Entry (entry_id,match_id,user_id) VALUES (entry_seq.NEXTVAL,:match_id,:user_id)",nativeQuery = true)
	void test(@Param("match_id") String match_id ,@Param("user_id") String user_id);
}
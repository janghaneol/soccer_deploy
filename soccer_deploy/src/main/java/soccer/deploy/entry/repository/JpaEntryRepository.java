package soccer.deploy.entry.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.entry.entity.Entry;
import soccer.deploy.user.entity.User;

public interface JpaEntryRepository extends JpaRepository<Entry, Long> {
	List<Entry> findAllByMatchId(Long matchId);
	
	@Query(value = "SELECT e.user_id id FROM entry e WHERE e.match_id = :match_id",nativeQuery = true)
	List<Long> findAllEntryUserByMatchId(@Param("match_id")Long matchId);
	
	
	List<Entry> findAllByUserId(Long id);
	
	@Query(value="SELECT  u.user_id id"
			+ "		FROM entry e"
			+ "   			 INNER JOIN users u"
			+ "   							 ON e.user_id = u.user_id"
			+ "		WHERE  e.match_id = :match_id",nativeQuery = true)
	List<Long> findUser(@Param("match_id") Long id);
	
	@Query(value="SELECT  e from Entry e join e.user u where e.match.id = :id and LOWER(u.name) like LOWER(concat('%',:name,'%'))")
	List<Entry> findSearchEntry(@Param("id") Long id , @Param("name") String name);
	 
	@Modifying
	@Transactional
	@Query(value="INSERT INTO Entry (entry_id,match_id,user_id) VALUES (entry_seq.NEXTVAL,:match_id,:user_id)",nativeQuery = true)
	void test(@Param("match_id") String match_id ,@Param("user_id") String user_id);
}
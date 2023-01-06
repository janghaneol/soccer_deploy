package soccer.deploy.entry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import soccer.deploy.lineUp.entity.LineUp;
import soccer.deploy.match.entity.Match;

public interface dksl extends JpaRepository<LineUp, Long> {
	@Query( value = "select u.name from LineUp l join l.entry e join e.user u join e.match m" )
	List<LineUp> findes();
	
	@Query(value="SELECT  name , "
			+ "			 	     matchDate,"
			+ "			 	     backNum, "
			+ "			 	    goal, "
			+ "			 	     assist,"
			+ "			 	     point "
			+ "			 	     FROM("
			+ "							SELECT u.name  name,"
			+ "								   m.match_date matchDate,"
			+ "								   u.backNum backNum,"
			+ "								   sum(l.goal) goal, "
			+ "								   sum(l.assist) assist, "
			+ "								   sum(l.point) point"
			+ "				            FROM match m join entry e"
			+ "				                    on m.match_id = e.match_id"
			+ "				                    join lineup l"
			+ "				                    on e.entry_id = l.entry_id"
			+ "				                    join users u"
			+ "				                    on u.user_id = e.user_id"
			+ "				            WHERE m.match_date LIKE :key%"
			+ "				            GROUP BY u.backNum,m.match_date,u.name"
			+ "				            ORDER BY point desc)"
			+ "            			WHERE rownum < 11",nativeQuery = true)
	List<testDto> dksl(@org.springframework.data.repository.query.Param("key") String key);
	
	
	@Query(value= "select m.matchDate from Match m")
	List<String> qwe();
	
}

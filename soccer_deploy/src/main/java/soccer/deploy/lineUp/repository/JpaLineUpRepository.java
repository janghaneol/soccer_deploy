package soccer.deploy.lineUp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import soccer.deploy.lineUp.entity.LineUp;
import soccer.deploy.match.myDto.rank;

public interface JpaLineUpRepository extends JpaRepository<LineUp, Long> {

	@Query(value="SELECT new soccer.deploy.match.myDto.rank(u.backNum,u.name,m.matchDate,SUM(l.goal),SUM(l.assist),SUM(l.point))"
			+ "FROM LineUp l join l.entry e join e.match m join e.user u "
			+ "WHERE m.id =:id and l.goal > 0"
			+ "GROUP BY u.backNum,m.matchDate,u.name"
			)
	public List<rank> findRecentMatchOutCome(@Param("id")Long id);
}

package soccer.deploy.match.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import soccer.deploy.match.entity.Match;

public interface JpaMatchRepository extends JpaRepository<Match, Long> {
	
	@Query(value = "SELECT max(m.id) FROM Match m ")
	public Long recentMatchNum();
	
	@Query(value = "SELECT m FROM Match m WHERE m.id =:id")
	public Optional<Match> recentMatch(@Param("id") Long id);
}

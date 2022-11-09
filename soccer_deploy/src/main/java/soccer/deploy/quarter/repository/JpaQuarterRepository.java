package soccer.deploy.quarter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import soccer.deploy.quarter.entity.Quarter;

public interface JpaQuarterRepository extends JpaRepository<Quarter, Long> {
	
	List<Quarter> findAllByMatchId(Long id);
}

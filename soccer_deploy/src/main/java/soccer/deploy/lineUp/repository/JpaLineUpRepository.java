package soccer.deploy.lineUp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import soccer.deploy.lineUp.entity.LineUp;

public interface JpaLineUpRepository extends JpaRepository<LineUp, Long> {

}

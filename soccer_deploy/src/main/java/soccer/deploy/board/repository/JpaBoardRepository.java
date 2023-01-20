package soccer.deploy.board.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soccer.deploy.board.entity.board;

@Repository
public interface JpaBoardRepository extends JpaRepository<board, String>{


}
package soccer.deploy.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soccer.deploy.board.entity.board;

@Repository
public interface JpaBoardRepository extends JpaRepository<board, String>{
	// 게시판 제목과 상세설명에 의한 조회
	public board findByTitleAndDescription(String title, String description);
	
	// 게시판 제목 또는 상세설명에 의한 검색 - 목록 페이징 처리
	public Page<board> findAllByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageable);
	
	public Optional<board> findByBoardId(int boardId);
	
	
	

}
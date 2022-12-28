package soccer.deploy.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import soccer.deploy.board.entity.board;

public interface BoardService {
	
	/* 게시판등록 */
	public int register(board Board);
	
	/** 회원 인증 */
	public board isBoard(String title, String description);
	
	/** 회원 상세 */
	public Optional<board> findBoard(int boardId);

	/** 전체 회원 조회 */
	public List<board> findBoards();
	
	/** 검색, 페이징 처리 회원 조회 */
	public Page<board> findBoards(String searchValue, Pageable pageable);

}

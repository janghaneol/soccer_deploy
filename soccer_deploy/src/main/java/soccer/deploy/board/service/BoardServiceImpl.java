package soccer.deploy.board.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import soccer.deploy.board.entity.board;
import soccer.deploy.board.repository.JpaBoardRepository;

@Slf4j
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private JpaBoardRepository jpaBoardRepository;
	
	@Override
	public int register(board Board) {
		board saveBoard = jpaBoardRepository.save(Board);
		return saveBoard.getBoardId();
	}

	@Override
	@Transactional(readOnly = true)
	public board isBoard(String title, String description) {
		return jpaBoardRepository.findByTitleAndDescription(title, description);
	}

	@Override
	public Optional<board> findBoard(int board_id) {
		return jpaBoardRepository.findByBoardId(board_id);
	}
	
	@Override
	public List<board> findBoards() {
		return jpaBoardRepository.findAll();
	}

	@Override
	public Page<board> findBoards(String searchValue, Pageable pageable) {
		return jpaBoardRepository.findAllByTitleContainingOrDescriptionContaining(searchValue, searchValue, pageable);
	}
	
}

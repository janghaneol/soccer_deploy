package soccer.deploy.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@DynamicInsert
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Slf4j
@ToString
@Table(name="board")
@SequenceGenerator( name= "board_id_seq_gen",
		sequenceName = "board_id_seq",
		initialValue = 1,
		allocationSize = 1)
public class board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_id_seq_gen")
	private int boardId;
	@Column(name="category")
	private int category;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	
	public board() {}
	
	public board(int boardId, int category, String title, String description) {
		super();
		this.boardId = boardId;
		this.category = category;
		this.title = title;
		this.description = description;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
}

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
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@Table(name="board")
@SequenceGenerator( name= "board_id_seq_gen",
		sequenceName = "board_id_seq",
		initialValue = 1,
		allocationSize = 1)
public class board {

	@Id
	@Column(name="board_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_id_seq_gen")
	private Long boardId;
	@Column(name="category")
	private Long category;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;

	
}

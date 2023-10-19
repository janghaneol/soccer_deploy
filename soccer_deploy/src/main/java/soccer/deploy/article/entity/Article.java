package soccer.deploy.article.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import soccer.deploy.board.entity.board;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Slf4j
@ToString
@Table(name="article")
@SequenceGenerator( name= "article_id_seq_gen",
		sequenceName = "article_seq",
		initialValue = 1,
		allocationSize = 1)
@DynamicUpdate
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_seq_gen")
	@Column(name="article_id")
	private Long articleId;
	
	@ManyToOne
	@JoinColumn(name="board_id",insertable = false, updatable = false)
	private board board;
	//숫자로 연관관계 설정
	@Column(name="board_id")
	private Long boardId;
	
	@Column(name="writer")
	private String writer;
	@Column(name="subject")
	private String subject;
	@Column(name="content")
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	@Column(name="hitcount")
	private Long hitcount;
	@Column(name="group_no")
	private Long groupNo;
	@Column(name="level_no")
	private Long levelNo;
	@Column(name="order_no")
	private Long orderNo;
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public board getBoard() {
		return board;
	}
	public void setBoard(board board) {
		this.board = board;
	}
	public Long getBoardId() {
		return boardId;
	}
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Long getHitcount() {
		return hitcount;
	}
	public void setHitcount(Long hitcount) {
		this.hitcount = hitcount;
	}
	public Long getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Long groupNo) {
		this.groupNo = groupNo;
	}
	public Long getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(Long levelNo) {
		this.levelNo = levelNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	
	
	
}



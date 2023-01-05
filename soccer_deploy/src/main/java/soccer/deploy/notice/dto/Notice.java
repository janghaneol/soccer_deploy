package soccer.deploy.notice.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@DynamicInsert
//@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
@NoArgsConstructor
@Table(name="notice")
@SequenceGenerator( name= "num_gen",
		sequenceName = "notice_num",
		initialValue = 1,
		allocationSize = 1)
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "num_gen")
	private Integer noticeId;
	private Integer articleId;
	private String writer;
	private String content;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
	
	
	
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	

	
	
	
	
	
	
}


//create table notice(
//	    articleId       NUMBER(7)        NOT NULL,
//	    writer          VARCHAR2(30)     NOT NULL, 
//		content         varchar2(2000), 
//		regdate         DATE             DEFAULT SYSDATE NOT NULL
//	);
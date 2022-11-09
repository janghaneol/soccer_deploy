package soccer.deploy.user.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
	private Long id;
	
	@Column(nullable = false)
	private String passwd;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private String address;
	
	@Column(name="img_cont_type")
	private String imgContType;
	@Column(name="img_file_name")
	private String imgFileName;
	
	@Column(name="backnum",nullable = false)
	private Integer backNum;
	
	@Column(name="member_auth",nullable = false)
	private String memberAuth;
	
	@Column(nullable = false)
	private String position;
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
}
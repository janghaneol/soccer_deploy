//package soccer.deploy.dto;
//
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
//
//@Entity
//@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
//public class User {
//
//	@Id
//	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
//	private Long id;
//
//	@Column(nullable = false)
//	private String email;
//
//	@Column(nullable = false)
//	private String password;
//
//	@Column(nullable = false)
//	private String name;
//
//	@Column
//	private Integer age;
//
//	@Column
//	private Integer backNum;
//
//	@Column
//	private Date regDate;
//}
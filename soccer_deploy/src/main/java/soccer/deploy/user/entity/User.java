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

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq", allocationSize = 1)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
<<<<<<< HEAD
@DynamicInsert
=======
@Table(name = "users")
>>>>>>> 5e8e0ee89f0163548983fa138acefc93c9c138f0
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
	@Column
	private String address;
	
	@Column(name="img_cont_type")
	private String imgContType;
	@Column(name="img_file_name")
	private String imgFileName;
	
<<<<<<< HEAD
	@Column(name = "back_Num")
=======
	@Column(name="backnum",nullable = false)
>>>>>>> 5e8e0ee89f0163548983fa138acefc93c9c138f0
	private Integer backNum;
	
	@Column(name="member_auth")
	private String memberAuth;
<<<<<<< HEAD
	@Column
=======
	
	@Column(nullable = false)
>>>>>>> 5e8e0ee89f0163548983fa138acefc93c9c138f0
	private String position;
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
}
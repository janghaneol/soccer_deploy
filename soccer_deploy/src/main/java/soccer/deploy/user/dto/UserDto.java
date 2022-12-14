package soccer.deploy.user.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	
	@NotBlank
	@Email(message = "이메일입력은 필수사항입니다.")
	private String email;
	
	@NotBlank(message = "비밀번호는 필수입력사항입니다.")
	@Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자로 포함해서 6 ~ 12자리 사이로 입력해주세요.")
	private String passwd;
	
	@NotBlank(message = "이름은 필수입력사항입니다.")
	private String name;
	
	private Integer age;
	
	private String address;
	
	@Column(name="img_cont_type")
	private String imgContType;
	
	@Column(name="img_file_name")
	private String imgFileName;
	
	@Column(name = "back_num")
	private Integer backNum;
	
	@Column(name="member_auth")
	private String memberAuth;
	
	private String position;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;
}

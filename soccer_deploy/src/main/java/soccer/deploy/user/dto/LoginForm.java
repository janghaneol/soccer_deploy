package soccer.deploy.user.dto;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {
	
	@NotBlank(message = "이메일을 입력해주세요.")
	private String email;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String passwd;
}

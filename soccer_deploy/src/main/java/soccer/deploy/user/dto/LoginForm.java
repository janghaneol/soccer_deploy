package soccer.deploy.user.dto;


import javax.validation.constraints.NotBlank;

import lombok.Data;

/*
 *  Entity 객체를 늘 불러오기엔 효율이 너무 떨어지고
 *  추후에 문제가 생길 위험이 높다. email과 passwd만 받으면
 *  Login이되는 페이지엔 따로 LoginFormDto를 작성해주는게 훨씬 효율적.
 */

@Data
public class LoginForm {
	
	@NotBlank(message = "이메일을 입력해주세요.")
	private String email;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String passwd;
}

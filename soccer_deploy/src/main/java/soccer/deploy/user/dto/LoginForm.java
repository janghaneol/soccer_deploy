package soccer.deploy.user.dto;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginForm {
	
	@NotBlank
	private String email;
	@NotBlank
	private String passwd;
}

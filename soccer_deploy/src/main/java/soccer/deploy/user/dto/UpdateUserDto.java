package soccer.deploy.user.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamicUpdate
public class UpdateUserDto {
	
	private String address;
	
	@Column(name="img_cont_type")
	private String imgContType;
	
	@Column(name="img_file_name")
	private String imgFileName;
	
	@Column(name = "back_num")
	private Integer backNum;
		
	private String position;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate;

	@Builder
	public UpdateUserDto(String address, String imgContType, String imgFileName, Integer backNum, String position,
			Date regdate) {
		this.address = address;
		this.imgContType = imgContType;
		this.imgFileName = imgFileName;
		this.backNum = backNum;
		this.position = position;
		this.regdate = regdate;
	}

	
}

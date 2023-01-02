package soccer.deploy.match.myDto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
	private Long matchId;
	private Date matchDate;
	private String opteam;
	private String matchImgType;
	private String matchImgName;
	private String matchPlace;
	private String win;
	private Long count;
}

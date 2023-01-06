package soccer.deploy.match.myDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class rank {
	private String backNum;
	private String name;
	private String matchDate;
	private String goal;
	private String assist;
	private String point;
	
	
}

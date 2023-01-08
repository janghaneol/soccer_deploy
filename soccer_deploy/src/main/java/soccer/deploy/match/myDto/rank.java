package soccer.deploy.match.myDto;

import java.util.Date;

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
	private int backNum;
	private String name;
	private Date matchDate;
	private Long goal;
	private Long assist;
	private Long point;
	
	
}

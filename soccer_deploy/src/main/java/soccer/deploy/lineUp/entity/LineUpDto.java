package soccer.deploy.lineUp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LineUpDto {
	String backNum;
	String name;
	String goal;
	String assist;
	String point;
	String quarter;
	String playerId;
}

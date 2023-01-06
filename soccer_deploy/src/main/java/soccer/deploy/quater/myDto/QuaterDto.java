package soccer.deploy.quater.myDto;

import soccer.deploy.match.myDto.matchMyDto;

public class QuaterDto {
	
	private int quaterId;	//PK
	private int quaterTime;
	private String outcome;
	private matchMyDto MatchMyDto;
	
	public QuaterDto() {}
	
	
	public QuaterDto(int quaterId, int quaterTime, String outcome, matchMyDto matchMyDto) {
		this.quaterId = quaterId;
		this.quaterTime = quaterTime;
		this.outcome = outcome;
		MatchMyDto = matchMyDto;
	}

	public int getQuaterId() {
		return quaterId;
	}

	public void setQuaterId(int quaterId) {
		this.quaterId = quaterId;
	}

	public int getQuaterTime() {
		return quaterTime;
	}

	public void setQuaterTime(int quaterTime) {
		this.quaterTime = quaterTime;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public matchMyDto getMatchMyDto() {
		return MatchMyDto;
	}

	public void setMatchMyDto(matchMyDto matchMyDto) {
		MatchMyDto = matchMyDto;
	}

	
	

	@Override
	public String toString() {
		return "QuaterDto [quaterId=" + quaterId + ", quaterTime=" + quaterTime + ", outcome=" + outcome
				+ ", MatchMyDto=" + MatchMyDto + "]";
	}
	
	
	
}
//create table quarter (
//		quarter_id	number(3)	not null, --PK
//		quarter_time	number(4),
//		outcome	varchar2(3),
//		match_id	number(3)	not null --FK
//	);
package soccer.deploy.match.myDto;

import java.util.Date;

import soccer.deploy.user.entity.User;

public class matchMyDto {
	private int id;
	private String matchDate;
	private String opteam;
	private Date matchRegdate;
	private String matchImgType;
	private String matchImgName;
	private String matchPlace;
	private int  userId;

	public matchMyDto() {
	}

	public matchMyDto(int id, String matchDate, String opteam, Date matchRegdate, String matchImgType,
			String matchImgName, String matchPlace, int userId) {
		super();
		this.id = id;
		this.matchDate = matchDate;
		this.opteam = opteam;
		this.matchRegdate = matchRegdate;
		this.matchImgType = matchImgType;
		this.matchImgName = matchImgName;
		this.matchPlace = matchPlace;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}

	public String getOpteam() {
		return opteam;
	}

	public void setOpteam(String opteam) {
		this.opteam = opteam;
	}

	public Date getMatchRegdate() {
		return matchRegdate;
	}

	public void setMatchRegdate(Date matchRegdate) {
		this.matchRegdate = matchRegdate;
	}

	public String getMatchImgType() {
		return matchImgType;
	}

	public void setMatchImgType(String matchImgType) {
		this.matchImgType = matchImgType;
	}

	public String getMatchImgName() {
		return matchImgName;
	}

	public void setMatchImgName(String matchImgName) {
		this.matchImgName = matchImgName;
	}

	public String getMatchPlace() {
		return matchPlace;
	}

	public void setMatchPlace(String matchPlace) {
		this.matchPlace = matchPlace;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "matchMyDto [id=" + id + ", matchDate=" + matchDate + ", opteam=" + opteam + ", matchRegdate="
				+ matchRegdate + ", matchImgType=" + matchImgType + ", matchImgName=" + matchImgName + ", matchPlace="
				+ matchPlace + ", userId=" + userId + "]";
	}

}

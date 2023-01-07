package soccer.deploy.MyEntry;

import lombok.Data;
import soccer.deploy.MyUser.UserMyDto;
import soccer.deploy.match.entity.Match;
import soccer.deploy.user.entity.User;


public class EntryMyDto {
	private int entry_id;
	private int match_id;
	private int user_id;
	
	private UserMyDto userMyDto;
	
	public  EntryMyDto() {}

	public EntryMyDto(int entry_id, int match_id, int user_id, UserMyDto userMyDto) {
		super();
		this.entry_id = entry_id;
		this.match_id = match_id;
		this.user_id = user_id;
		this.userMyDto = userMyDto;
	}

	
	public UserMyDto getUserMyDto() {
		return userMyDto;
	}

	public void setUserMyDto(UserMyDto userMyDto) {
		this.userMyDto = userMyDto;
	}

	public int getEntry_id() {
		return entry_id;
	}

	public void setEntry_id(int entry_id) {
		this.entry_id = entry_id;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "EntryMyDto [entry_id=" + entry_id + ", match_id=" + match_id + ", user_id=" + user_id + ", userMyDto="
				+ userMyDto + "]";
	}




	
}

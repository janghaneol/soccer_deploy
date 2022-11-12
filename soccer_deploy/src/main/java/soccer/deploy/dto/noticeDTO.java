package soccer.deploy.dto;

import lombok.Data;

@Data
public class noticeDTO {
	private int notice_index;
	private String notice_title;
	private String notice_content;
	private String notice_date;
	private int notice_count;
	
	public noticeDTO() {}
	
	public noticeDTO(int notice_index, String notice_title, String notice_content, String notice_date,
			int notice_count) {
		super();
		this.notice_index = notice_index;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.notice_count = notice_count;
	}

	public int getNotice_index() {
		return notice_index;
	}

	public void setNotice_index(int notice_index) {
		this.notice_index = notice_index;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}

	public int getNotice_count() {
		return notice_count;
	}

	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}
	
	
	
}

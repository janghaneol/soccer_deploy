package soccer.deploy.dto;

import lombok.Data;

@Data
public class pageDTO {
	
	private int pagenum=1;
	private int amount;
	private int startnum;
	private int endnum;
	
	public pageDTO() {pagenum = 1;}
	
	public pageDTO(int pagenum, int amount, int startnum, int endnum) {
		super();
		this.pagenum = pagenum;
		this.amount = amount;
		this.startnum = startnum;
		this.endnum = endnum;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStartnum() {
		return startnum;
	}

	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}

	public int getEndnum() {
		return endnum;
	}

	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}
	
	
	
	
	
}

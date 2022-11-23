package soccer.deploy.dto;

public class clickpagenumDTO {
	
	private int clicknum;
	private int total;
	private int startclicknum;
	private int endclicknum;
	
	public clickpagenumDTO() {}
	
	public clickpagenumDTO(int clicknum, int total, int startclicknum, int endclicknum) {
		super();
		this.clicknum = clicknum;
		this.total = total;
		this.startclicknum = startclicknum;
		this.endclicknum = endclicknum;
	}

	public int getClicknum() {
		return clicknum;
	}

	public void setClicknum(int clicknum) {
		this.clicknum = clicknum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStartclicknum() {
		return startclicknum;
	}

	public void setStartclicknum(int startclicknum) {
		this.startclicknum = startclicknum;
	}

	public int getEndclicknum() {
		return endclicknum;
	}

	public void setEndclicknum(int endclicknum) {
		this.endclicknum = endclicknum;
	}
	
	

}
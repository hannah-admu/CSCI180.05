package app.dto;

public class QuoteDTO {
	
	private Long pk;
	private String message;
	private String category;
	
	public Long getPk() {
		return pk;
	}
	
	public void setPk(Long pk) {
		this.pk = pk;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}

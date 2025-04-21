package domain;

public class UserData {
	
	private String username;
	private String email;
	
	public UserData(String username,String email) {
		this.username = username;
		this.email = email;
	}
	
	public String GetName() {
		return username;
	}
	
	public String GetEmail() {
		return email;
	}
	
}

package domain;

public class UserData {
	
	private String userName;
	private String eMail;
	private boolean exist;
	
	public UserData(String userName,String eMail,boolean exist) {
		this.userName = userName;
		this.eMail = eMail;
		this.exist = exist;
	}
	
	public String getName() {
		return userName;
	}
	
	public String getEmail() {
		return eMail;
	}
	
	public boolean userExist() {
		return exist;
	}
	
	public void setExist(boolean existFlag) {
		exist = existFlag;
	}
}

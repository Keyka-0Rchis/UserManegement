package service;

public class ServiceResult {

	private final boolean success;
	private final String message;
	
	public ServiceResult(boolean success,String message) {
		this.success = success;
		this.message =  message;
	}
	
	public boolean isResultSuccess() {
		return success;
	}
	
	public String getResultMessage() {
		return message;
	}
	
}

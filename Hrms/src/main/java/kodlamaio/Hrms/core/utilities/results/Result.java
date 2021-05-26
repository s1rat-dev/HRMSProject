package kodlamaio.Hrms.core.utilities.results;

public class Result {
	
	
	private boolean success;
	private String message;
	
	
	public Result(boolean success)
	{
		this.setSuccess(success);
	}
	
	public Result(boolean success, String message)
	{
		this.setMessage(message);
		this.setSuccess(success);
	}
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}

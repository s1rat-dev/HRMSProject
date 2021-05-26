package kodlamaio.Hrms.business.abstracts;

public interface AuthService {
	
	String getMessage();
	boolean checkEmail(String email);
	boolean checkIdentityNumber(String identityNumber);
	boolean checkingCenter(String email, String identityNumber);
	
}

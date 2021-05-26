package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.core.utilities.adapters.EmailService;
import kodlamaio.Hrms.core.utilities.adapters.MernisService;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;

@Service
public class AuthManager implements AuthService{
	
	UserDao userDao;
	MernisService mernisService;
	EmailService emailService;
	
	private String messageDetail = "";
	
	@Autowired
	public AuthManager(EmailService emailService, MernisService mernisService, UserDao userDao)
	{
		this.emailService = emailService;
		this.mernisService = mernisService;
		this.userDao = userDao;
	}
	
	
	
	@Override
	public boolean checkEmail(String email) {
		
		this.messageDetail = "";
		
		if(!this.emailService.isOkay(email))
		{
			this.messageDetail += "Gerçek bir email adresi giriniz.";
			return false;
		}
		
		if(!this.userDao.findByEmail(email).isEmpty())
		{
			this.messageDetail += "Girdiginiz mail zaten sistemde mevcut.";
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean checkIdentityNumber(String identityNumber) {
		
		this.messageDetail = "";
		
		if(!this.mernisService.isOkay(identityNumber))
		{
			this.messageDetail += "Tc numarası 11 hane olmak zorunda.";
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean checkingCenter(String email, String identityNumber) {
		
		return (this.checkEmail(email) && this.checkIdentityNumber(identityNumber));
	}
	
	public String getMessage()
	{
		return this.messageDetail;
	}

}

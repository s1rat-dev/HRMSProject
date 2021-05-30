package kodlamaio.Hrms.core.utilities.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.fakeEmailService.FakeEmailManager;

@Service
public class EmailAdapter implements EmailService{
	
	@Autowired
	FakeEmailManager fakeEmailManager;
	
	
	@Override
	public boolean isOkay(String email)
	{
		return this.fakeEmailManager.isOkay(email);
	}
	
}

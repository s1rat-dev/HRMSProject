package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private AuthService authService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, AuthService authService)
	{
		this.employerDao = employerDao;
		this.authService = authService;
	}

	@Override
	public Result add(Employer employer) {
		
		if(this.authService.checkEmail(employer.getUser().getEmail()))
		{	
			this.employerDao.save(employer);
			return new SuccessResult("Employer başarıyla eklendi.");
		}
		return new ErrorResult(this.authService.getMessage());
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer bilgisi başarıyla getirildi.");
	}
	
	
	
	
	
	
}

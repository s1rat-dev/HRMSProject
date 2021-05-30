package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.SystemUserService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SystemUserDao;
import kodlamaio.Hrms.entities.concretes.SystemUser;


@Service
public class SystemUserManager implements SystemUserService{

	SystemUserDao systemUserDao;
	AuthService authService;
	
	@Autowired
	public SystemUserManager(SystemUserDao systemUserDao, AuthService authService)
	{
		this.systemUserDao = systemUserDao;
		this.authService = authService;
	}
	

	
	@Override
	public Result add(SystemUser systemUser) {
		
		if(this.authService.checkEmail(systemUser.getUser().getEmail()))
		{
			this.systemUserDao.save(systemUser);
			return new SuccessResult("System user başarıyla eklendi.");
		}
		else
			return new ErrorResult(this.authService.getMessage());
		
	}



	@Override
	public DataResult<List<SystemUser>> getAll() {
		return new SuccessDataResult<List<SystemUser>>(this.systemUserDao.findAll(),"System user bilgisi başarıyla getirildi.");
	}

}

package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.UserService;
import kodlamaio.Hrms.dataAccess.abstracts.UserDao;
import kodlamaio.Hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao)
	{
		this.userDao = userDao;
	}
	
	
	@Override
	public List<User> getAll() {		
		return this.userDao.findAll(); 
	}
	
}

package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.entities.concretes.User;

public interface UserService {
	
	List<User> getAll();
	void add(User user);
}

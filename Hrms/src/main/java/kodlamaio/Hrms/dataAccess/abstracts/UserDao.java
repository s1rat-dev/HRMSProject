package kodlamaio.Hrms.dataAccess.abstracts;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	List<User> findByEmail(String email);
	
}

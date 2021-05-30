package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
	
	List<Announcement> findByStatus(boolean status, Sort sort);
	List<Announcement> getByEmployerCompanyNameAndStatus(String companyName,boolean status);
	Announcement getById(int id);
	
}

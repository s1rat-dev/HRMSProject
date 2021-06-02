package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Announcement;

public interface AnnouncementDao extends JpaRepository<Announcement, Integer>{
	
	List<Announcement> getByStatusTrueOrderByCreatedDateAsc();
	List<Announcement> getByStatusTrue();
	List<Announcement> getByEmployerCompanyNameAndStatusTrue(String companyName);
	Announcement getById(int id);
	
}

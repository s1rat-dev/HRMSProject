package kodlamaio.Hrms.business.abstracts;


import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Announcement;

public interface AnnouncementService {
	Result add(Announcement announcement);
	DataResult<List<Announcement>> getAll();
	DataResult<List<Announcement>> getByStatus();
	DataResult<List<Announcement>> getByCompanyName(String companyName);
	Result closeAnnouncement(int id); 
	
}

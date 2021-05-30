package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AnnouncementService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.AnnouncementDao;
import kodlamaio.Hrms.entities.concretes.Announcement;

@Service
public class AnnouncementManager implements AnnouncementService{

	private AnnouncementDao announcementDao;
	
	@Autowired
	public AnnouncementManager(AnnouncementDao announcementDao)
	{
		this.announcementDao = announcementDao;
	}
	
	
	
	@Override
	public Result add(Announcement announcement) {
		this.announcementDao.save(announcement);
		return new SuccessResult("Başarılı.");
	}

	@Override
	public DataResult<List<Announcement>> getAll() {
		return new SuccessDataResult<List<Announcement>>(this.announcementDao.findAll(),"Başarılı");
	}



	@Override
	public DataResult<List<Announcement>> getByStatus() {
		Sort sortedCreatedDate = Sort.by(Sort.Direction.ASC, "createdDate");
		return new SuccessDataResult<List<Announcement>>(this.announcementDao.findByStatus(true,sortedCreatedDate),"Başarılı");
	}



	@Override
	public DataResult<List<Announcement>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<Announcement>>(this.announcementDao.getByEmployerCompanyNameAndStatus(companyName, true),"Başarılı");
	}



	@Override
	public Result closeAnnouncement(int id) {
		
		if(this.announcementDao.getById(id).isStatus())
		{
			this.announcementDao.getById(id).setStatus(false);
			this.announcementDao.save(this.announcementDao.getById(id));
			return new SuccessResult("İlan silindi.");
		}
		else
			return new ErrorResult("İlan zaten silinmiş.");
	}

}

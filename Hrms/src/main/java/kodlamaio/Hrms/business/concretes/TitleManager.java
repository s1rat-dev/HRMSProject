package kodlamaio.Hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.TitleService;
import kodlamaio.Hrms.dataAccess.abstracts.TitleDao;
import kodlamaio.Hrms.entities.concretes.Title;

@Service
public class TitleManager implements TitleService{

	TitleDao titleDao;
	
	@Autowired
	public TitleManager(TitleDao titleDao) {
		super();
		this.titleDao = titleDao;
	}


	@Override
	public List<Title> getAll() {
		
		return this.titleDao.findAll();
	}

}

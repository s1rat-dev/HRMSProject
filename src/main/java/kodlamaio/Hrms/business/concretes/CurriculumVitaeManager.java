package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;


@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao)
	{
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"Başarılı");
	
	}
	
	
	
}

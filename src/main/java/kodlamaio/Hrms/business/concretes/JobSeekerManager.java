package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.AuthService;
import kodlamaio.Hrms.business.abstracts.JobSeekerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.Hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private AuthService authService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, AuthService authService)
	{
		this.jobSeekerDao = jobSeekerDao;
		this.authService = authService;
	}


	@Override
	public Result add(JobSeeker jobSeeker) {
		
		if(this.authService.checkingCenter(jobSeeker.getUser().getEmail(), jobSeeker.getNationalityId()))
		{
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Job seeker başarıyla eklendi.");
		}
		else
			return new ErrorResult(this.authService.getMessage());
		
	}
	
	public DataResult<List<JobSeeker>> getAll()
	{
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Job seeker bilgisi başarıyla getirildi.");
	}
	
	
}

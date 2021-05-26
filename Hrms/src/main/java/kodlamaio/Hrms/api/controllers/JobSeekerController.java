package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobSeekerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/job-seekers")
public class JobSeekerController {
	
	JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService)
	{
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll()
	{
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(JobSeeker jobSeeker)
	{
		return this.jobSeekerService.add(jobSeeker);
	}
	
	
	
}

package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumvitaes")
public class CurriculumVitaeController {

	CurriculumVitaeService curriculumVitaeService;
	
	
	@Autowired
	public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService)
	{
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll()
	{
		return this.curriculumVitaeService.getAll();
	}
	
}

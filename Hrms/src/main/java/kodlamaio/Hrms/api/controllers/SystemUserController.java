package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SystemUserService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SystemUser;

@RestController
@RequestMapping("/api/system-users")
public class SystemUserController {

	private SystemUserService systemUserService;
	
	
	@Autowired
	public SystemUserController(SystemUserService systemUserService)
	{
		this.systemUserService = systemUserService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemUser>> getAll()
	{
		return this.systemUserService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemUser systemUser)
	{
		return this.systemUserService.add(systemUser);
	}
	
	
}

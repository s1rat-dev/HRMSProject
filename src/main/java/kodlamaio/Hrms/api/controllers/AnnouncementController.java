package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.AnnouncementService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Announcement;

@RequestMapping("/api/announcements")
@RestController
public class AnnouncementController {
	
	private AnnouncementService announcementService;
	
	@Autowired
	public AnnouncementController(AnnouncementService announcementService)
	{
		this.announcementService = announcementService;
	}
	
	
	@PostMapping("/add")
	public Result addAnnouncement(@RequestBody Announcement announcement)
	{
		return this.announcementService.add(announcement);
	}
	
	
	@PostMapping("/deleteannouncement")
	public Result closeAnnouncement(@RequestParam int id)
	{
		return this.announcementService.closeAnnouncement(id);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Announcement>> getAll()
	{
		return this.announcementService.getAll();
	}
	
	@GetMapping("/getallsorted")
	public DataResult<List<Announcement>> getAllSorted()
	{
		return this.announcementService.getByStatus();
	}
	
	@GetMapping("/getallannouncementsbycompanyname")
	public DataResult<List<Announcement>> getAllByCompanyName(@RequestParam String companyName)
	{
		return this.announcementService.getByCompanyName(companyName);
	}
	
}

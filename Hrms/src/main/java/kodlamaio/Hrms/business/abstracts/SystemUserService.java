package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.SystemUser;

public interface SystemUserService {
	
	Result add(SystemUser systemUser);
	DataResult<List<SystemUser>> getAll();
}

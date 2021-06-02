package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	DataResult<List<CurriculumVitae>> getAll();
}

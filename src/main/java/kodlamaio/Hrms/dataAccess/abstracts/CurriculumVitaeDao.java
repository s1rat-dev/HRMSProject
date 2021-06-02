package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{

}

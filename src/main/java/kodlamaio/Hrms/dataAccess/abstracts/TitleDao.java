package kodlamaio.Hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.Hrms.entities.concretes.Title;

public interface TitleDao extends JpaRepository<Title, Integer>{

}

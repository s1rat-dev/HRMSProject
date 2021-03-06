package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "curriculumVitae"})
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY, targetEntity = User.class, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "userid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private User user;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "birthdate")
	private Date birthDate;
	
	@Column(name = "nationalityid")
	private String nationalityId;
	
	@OneToOne(mappedBy = "jobSeeker")
	private CurriculumVitae curriculumVitae;
	
	
}

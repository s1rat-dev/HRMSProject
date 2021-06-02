package kodlamaio.Hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "curriculum_vitaes")
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne()
	@JoinColumn(name = "jobseekerid")
	private JobSeeker jobSeeker;
	
	@Column(name = "pictureurl")
	private String pictureUrl;
	
	@Column(name = "githuburl")
	private String githubUrl;
	
	@Column(name = "linkedinurl")
	private String linkedinUrl;
	
	@Column(name = "describe")
	private String describe;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<ProgramOrTechnologyLanguage> programOrTechnologyLanguages;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "curriculumVitae")
	private List<Business> businesses;
	
	
}

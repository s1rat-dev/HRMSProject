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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@ManyToOne()
	@JoinColumn(name = "cvid")
	private CurriculumVitae curriculumVitae;
	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = EducationType.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "educationtypeid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private EducationType educationType;
	
	
	@Column(name = "educationname")
	private String educationName;
	
	
	@Column(name = "branchname")
	private String branchName;
	
	
	@Column(name = "startdate")
	private Date startDate;
	
	
	@Column(name = "graduatedate")
	private Date graduateDate;
}

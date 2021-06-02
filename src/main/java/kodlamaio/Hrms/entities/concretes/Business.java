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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "businesses")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class Business {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "cvid")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "cityid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Title.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "jobtitleid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Title title;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "startdate")
	private Date startDate;
	
	@Column(name = "enddate")
	private Date endDate;
	
	
}

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

@Data
@Entity
@Table(name = "announcements")
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "employerid")
//	private int employerId;
//	
//	@Column(name = "jobtitleid")
//	private int titleId;
//	
//	@Column(name = "cityid")
//	private int cityId;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employer.class, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "employerid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Employer employer;
	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Title.class, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "jobtitleid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Title title;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "cityid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private City city;
	
	
	@Column(name = "detail")
	private String detail;
	
	@Column(name = "minsalary")
	private int minSalary;
	
	@Column(name = "maxsalary")
	private int maxSalary;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "lastdate")
	private Date lastDate;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "numofhires")
	private int numberOfHires;
	
}

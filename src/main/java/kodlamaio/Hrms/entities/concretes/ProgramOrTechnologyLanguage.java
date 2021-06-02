package kodlamaio.Hrms.entities.concretes;

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
@Table(name = "program_or_technology_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","curriculumVitae"})
public class ProgramOrTechnologyLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "cvid")
	private CurriculumVitae curriculumVitae;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LanguageType.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "typenameid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private LanguageType languageType;
	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LanguageName.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "languageid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private LanguageName languageName;
	 
	
}

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
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "language_names")
public class LanguageName {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = LanguageType.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "typenameid", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private LanguageType languageType;
	
	@Column(name = "languagename")
	private String languageName;
	
	
}

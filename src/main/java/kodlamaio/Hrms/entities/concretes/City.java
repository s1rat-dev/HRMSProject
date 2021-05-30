package kodlamaio.Hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cities")
@NoArgsConstructor
@AllArgsConstructor
public class City {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "cityname")
	private String cityName;
	
		

}

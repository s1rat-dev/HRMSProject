package kodlamaio.Hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;
	
	@Column(name = "emailid")
	private String email;
	
	@Column(name = "password_")
	private String password;
	
	@Column(name = "isactivated")
	private boolean isActivated;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "status")
	private boolean status;
	
}

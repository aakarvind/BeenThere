package beenthere.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.util.digester.SetRootRule;

import beenthere.model.User;

@Entity
@Table(name = "UserDetails")
public class UserEntity 
{
	// Attr in db
	private String name;
	
	@Id
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	private String password;
	
	private String country;
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Calendar dob;
	
	private String dpStr;
	
	//Additional attr
	private Integer wrongAttempts;
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getDpStr() {
		return dpStr;
	}

	public void setDpStr(String dpStr) {
		this.dpStr = dpStr;
	}

	// Constructors
	public UserEntity(){}
	
	public UserEntity(User user) {
		this.setName(user.getName());
		this.setEmail(user.getEmail());
		this.setContactNumber(user.getContactNumber());
		this.setPassword(user.getPassword());
		setDob(user.getDob());
		setDpStr(user.getDpStr());
		setGender(user.getGender());
		setCountry(user.getCountry());
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWrongAttempts() {
		return wrongAttempts;
	}

	public void setWrongAttempts(Integer wrongAttempts) {
		this.wrongAttempts = wrongAttempts;
	}
}

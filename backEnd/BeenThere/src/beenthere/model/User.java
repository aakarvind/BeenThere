package beenthere.model;

import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import beenthere.entity.UserEntity;

public class User 
{
	private String name;
	private String email;
	private String contactNumber;
	private String password;
	private Long numberOfPlacesVisited;
	private Long numberOfConnections;
	private Integer wrongAttempts;
	private String country;
	private String gender;
	
	@Temporal(TemporalType.DATE)
	private Calendar dob;
	
	private String dpStr;
	
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

	public Long getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(Long numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}

	public Long getNumberOfPlacesVisited() {
		return numberOfPlacesVisited;
	}

	public void setNumberOfPlacesVisited(Long numberOfPlacesVisited) {
		this.numberOfPlacesVisited = numberOfPlacesVisited;
	}

	public User(){}
	
	public User(UserEntity entity)
	{
		this.setName(entity.getName());
		this.setEmail(entity.getEmail());
		this.setContactNumber(entity.getContactNumber());
		this.setPassword(null);
		setDob(entity.getDob());
		setDpStr(entity.getDpStr());
		setGender(entity.getGender());
		setCountry(entity.getCountry());
	}
	
	public User(UserEntity entity, Long noOfConnections)
	{
		this.setName(entity.getName());
		this.setEmail(entity.getEmail());
		this.setContactNumber(entity.getContactNumber());
		this.setPassword(null);
		this.setNumberOfConnections(noOfConnections);
	}
	
	public User(UserEntity entity, Long numberOfPlacesVisited, Integer differentiate)
	{
		this.setName(entity.getName());
		this.setEmail(entity.getEmail());
		this.setContactNumber(entity.getContactNumber());
		this.setPassword(null);
		this.setNumberOfPlacesVisited(numberOfPlacesVisited);
	}
	
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

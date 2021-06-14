package beenthere.model;

import beenthere.entity.AdminEntity;

public class Admin 
{
	// attr in db
	private String name;
	private String email;
	private Integer adminId;
	private String password;
	private Integer wrongAttempts;

	// default and entity conversion constructors
	public Admin(){}
	
	public Admin(AdminEntity entity)
	{
		this.setName(entity.getName());
		this.setEmail(entity.getEmail());
		this.setAdminId(entity.getAdminId());
		this.setPassword(null);
		this.setWrongAttempts(entity.getWrongAttempts());
	}
	
	// getters and setters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getWrongAttempts() {
		return wrongAttempts;
	}
	public void setWrongAttempts(Integer wrongAttempts) {
		this.wrongAttempts = wrongAttempts;
	}
}

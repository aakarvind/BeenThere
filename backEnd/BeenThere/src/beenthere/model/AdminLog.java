package beenthere.model;

import java.util.Date;

import beenthere.entity.AdminLogEntity;

public class AdminLog {
	private Integer adminLogId;
	private Date logInTime;
	private Date logOffTime;
	private String adminID;
	
	//constructors
	public AdminLog(){}
	
	public AdminLog(AdminLogEntity entity){
		setAdminID(entity.getAdminID());
		setAdminLogId(entity.getAdminLogId());
		setLogInTime(entity.getLogInTime());
		setLogOffTime(entity.getLogOffTime());
	}
	
	//getters and setters
	public Integer getAdminLogId() {
		return adminLogId;
	}
	public void setAdminLogId(Integer adminLogId) {
		this.adminLogId = adminLogId;
	}
	public Date getLogInTime() {
		return logInTime;
	}
	public void setLogInTime(Date logInTime) {
		this.logInTime = logInTime;
	}
	public Date getLogOffTime() {
		return logOffTime;
	}
	public void setLogOffTime(Date logOffTime) {
		this.logOffTime = logOffTime;
	}
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
}

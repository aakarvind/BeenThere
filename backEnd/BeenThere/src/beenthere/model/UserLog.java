package beenthere.model;

import java.util.Date;

import beenthere.entity.UserLogEntity;

public class UserLog {
	private Integer userLogId;
	private Date logInTime;
	private Date logOffTime;
	private String userEmailID;

	//constructors
	public UserLog(){}
	
	public UserLog(UserLogEntity entity){
		setUserLogId(entity.getUserLogId());
		setUserEmailID(entity.getUserEmailID());
		setLogInTime(entity.getLogInTime());
		setLogOffTime(entity.getLogOffTime());
	}
	
	public Integer getUserLogId() {
		return userLogId;
	}
	public void setUserLogId(Integer userLogId) {
		this.userLogId = userLogId;
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
	public String getUserEmailID() {
		return userEmailID;
	}
	public void setUserEmailID(String userEmailID) {
		this.userEmailID = userEmailID;
	}
}

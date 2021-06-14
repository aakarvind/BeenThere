package beenthere.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UserLog")
@GenericGenerator(name = "userLogIdGen", strategy = "increment")
public class UserLogEntity {
	@Id
	@GeneratedValue(generator = "userLogIdGen")
	private Integer userLogId;
	
	private Date logInTime;
	private Date logOffTime;
	private String userEmailID;
	
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
	public Integer getUserLogId() {
		return userLogId;
	}
}

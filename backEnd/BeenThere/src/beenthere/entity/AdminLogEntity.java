package beenthere.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beenthere.model.AdminLog;


@Entity
@Table(name = "AdminLog")
@GenericGenerator(name = "adminLogIdGen", strategy = "increment")
public class AdminLogEntity {
	@Id
	@GeneratedValue(generator = "adminLogIdGen")
	private Integer adminLogId;
	
	private Date logInTime;
	private Date logOffTime;
	private String adminID;
	
	//constructors
	public AdminLogEntity(){}

	public AdminLogEntity(AdminLog model){
		setAdminID(model.getAdminID());
		setLogInTime(model.getLogInTime());
		setLogOffTime(model.getLogOffTime());
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
	public Integer getAdminLogId() {
		return adminLogId;
	}
}
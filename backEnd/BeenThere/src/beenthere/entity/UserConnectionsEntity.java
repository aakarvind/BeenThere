package beenthere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userConnections")
@GenericGenerator(name = "userConnectionIdGen", strategy = "increment")
public class UserConnectionsEntity {
	@Id
	@Column(name = "user_connection_id")
	@GeneratedValue(generator = "userConnectionIdGen")
	private Integer userConnectionId;

	@Column(name = "to_user_id")
	private String toUserId;

	@Column(name = "from_user_id")
	private String fromUserId;
	
	public Integer getUserConnectionId() {
		return userConnectionId;
	}
	public void setUserConnectionId(Integer userConnectionId) {
		this.userConnectionId = userConnectionId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
}

package beenthere.model;

import java.util.Date;

public class Messgaes {
	
	
	  public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getReciverEmailId() {
		return reciverEmailId;
	}
	public void setReciverEmailId(String reciverEmailId) {
		this.reciverEmailId = reciverEmailId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Date getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
	public String getSendersName() {
		return sendersName;
	}
	public void setSendersName(String sendersName) {
		this.sendersName = sendersName;
	}
	public String getReciversName() {
		return reciversName;
	}
	public void setReciversName(String reciversName) {
		this.reciversName = reciversName;
	}
	 private Integer msgId;
	private String senderEmailId;
	  private String reciverEmailId;
	  private String data;
	  private Date msgTime;
	  private String sendersName;
	  private String reciversName;

}

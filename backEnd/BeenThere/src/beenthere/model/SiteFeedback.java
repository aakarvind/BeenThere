package beenthere.model;

import beenthere.entity.SiteFeedbackEntity;


public class SiteFeedback {
	private Integer feedbackId;
	private Integer satisfactionLevel;
	private String feedback;
	private String userId;
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//constructors
	public SiteFeedback(){}
	
	public SiteFeedback(SiteFeedbackEntity entity){
		setFeedbackId(entity.getFeedbackId());
		setFeedback(entity.getFeedback());
		setSatisfactionLevel(entity.getSatisfactionLevel());
		setUserId(entity.getUserId());
	}
	
	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Integer getSatisfactionLevel() {
		return satisfactionLevel;
	}
	public void setSatisfactionLevel(Integer satisfactionLevel) {
		this.satisfactionLevel = satisfactionLevel;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}

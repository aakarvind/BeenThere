package beenthere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beenthere.model.SiteFeedback;

@Entity
@Table(name = "site_feedback")
@GenericGenerator(name = "feedbackIdGen", strategy = "increment")
public class SiteFeedbackEntity {
	@Id
	@Column(name = "feedback_id")
	@GeneratedValue(generator = "feedbackIdGen")
	private Integer feedbackId;
	
	@Column(name = "satisfaction_level")
	private Integer satisfactionLevel;
	
	@Column(name = "feedback_text")
	private String feedback;
	
	@Column(name = "user_id")
	private String userId;
	
	//constructors
	public SiteFeedbackEntity(){}

	public SiteFeedbackEntity(SiteFeedback model){
		setFeedback(model.getFeedback());
		setSatisfactionLevel(model.getSatisfactionLevel());
		setUserId(model.getUserId());
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

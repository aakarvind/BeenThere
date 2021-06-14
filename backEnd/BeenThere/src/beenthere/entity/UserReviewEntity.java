package beenthere.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import beenthere.model.UserReview;

@Entity
@Table(name = "UserReviews")
@GenericGenerator(name = "reviewIdGen", strategy = "sequence")
public class UserReviewEntity 
{
	@Id
	@Column(name = "review_Id")
	@GeneratedValue(generator = "reviewIdGen")
	private Integer reviewId;
	
	private String review;
	private Integer rating;
	
	private Date timeStamp;
	private String userEmail;
	private String privacyPreference;
	private Integer placeId;
	private Integer likes;
	private Integer dislikes;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "reviewsImages",
		joinColumns = @JoinColumn(		//refers to origin table
					name = "review", // attr name in lookup(new) table
					referencedColumnName = "review_Id" // attr name in originall data table
					),
		inverseJoinColumns = @JoinColumn(		//inverse refers to target table
					name = "image",		//attr name in lookup(new) table
					referencedColumnName = "imageId",	// attr name in target table
					unique = true	//observe the table attr defn.. its mentioned
					)
		)
	private List<ImageEntity> imageEntities = new ArrayList<>();


	public UserReviewEntity(){}
	
	public UserReviewEntity(UserReview userReview)
	{
		setReview(userReview.getReview());
		setRating(userReview.getRating());
		setPlaceId(userReview.getPlaceId());
		setPrivacyPreference(userReview.getPrivacyPreference());
		setLikes(userReview.getLikes());
		setDislikes(userReview.getDislikes());
		setTimeStamp(userReview.getTimeStamp());
		setUserEmail(userReview.getUserEmail());
	}
	
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId= reviewId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}	
	public List<ImageEntity> getImageEntities() {
		return imageEntities;
	}
	public void setImageEntities(List<ImageEntity> imageEntities) {
		this.imageEntities = imageEntities;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPrivacyPreference() {
		return privacyPreference;
	}

	public void setPrivacyPreference(String privacyPreference) {
		this.privacyPreference = privacyPreference;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}
	
}

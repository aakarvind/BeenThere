package beenthere.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beenthere.entity.ImageEntity;
import beenthere.entity.UserReviewEntity;

public class UserReview 
{
	private Integer reviewId;
	private String review;
	private Integer rating;
	private List<Image> images = new ArrayList<>();
	private Date timeStamp;
	private String userEmail;
	private String privacyPreference;
	private Integer placeId;
	private Integer likes;
	private Integer dislikes;

	public UserReview(){}
	
	public UserReview(UserReviewEntity reviewEntity)
	{
		if(reviewEntity.getReviewId() != null)
			this.setReviewId(reviewEntity.getReviewId());
		
		this.setReview(reviewEntity.getReview());
		this.setRating(reviewEntity.getRating());
		setPlaceId(reviewEntity.getPlaceId());
		setPrivacyPreference(reviewEntity.getPrivacyPreference());
		setUserEmail(reviewEntity.getUserEmail());
		setTimeStamp(reviewEntity.getTimeStamp());
		setLikes(reviewEntity.getLikes());
		setDislikes(reviewEntity.getDislikes());
		
		for(ImageEntity imgEntity : reviewEntity.getImageEntities())
		{
			Image img = new Image(imgEntity);
			this.getImages().add(img);
		}
	} 

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
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

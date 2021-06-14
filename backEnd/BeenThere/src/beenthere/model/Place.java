package beenthere.model;

import java.util.ArrayList;
import java.util.List;

import beenthere.entity.ImageEntity;
import beenthere.entity.PlaceEntity;
import beenthere.entity.UserReviewEntity;

public class Place 
{
	private Integer placeId;
	private String name;	
	private String description;
	private Integer avgRating;
	private Integer pageViewCount;
	private Long noOfReviews;
	private List<UserReview> reviews = new ArrayList<>();
	private List<Image> placeImages = new ArrayList<>();
	private Integer cityId;
	private String placeCreationImageString;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placeId == null) ? 0 : placeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (placeId == null) {
			if (other.placeId != null)
				return false;
		} else if (!placeId.equals(other.placeId))
			return false;
		return true;
	}

	public String getPlaceCreationImageString() {
		return placeCreationImageString;
	}

	public void setPlaceCreationImageString(String placeCreationImageString) {
		this.placeCreationImageString = placeCreationImageString;
	}

	public Place(){}
	
	public Place(PlaceEntity placeEntity)
	{
		this.setPlaceId(placeEntity.getPlaceId());
		this.setName(placeEntity.getName());
		this.setAvgRating(placeEntity.getAvgRating());
		this.setCityId(placeEntity.getCityId());
		this.setDescription(placeEntity.getDescription());
		this.setPageViewCount(placeEntity.getPageViewCount());
		
		if(placeEntity.getReviewEntities() != null)
		{
			for(UserReviewEntity reviewEntity : placeEntity.getReviewEntities())
			{
				this.reviews.add(new UserReview(reviewEntity));
			}
		}
		
		for(ImageEntity placeImgEntity : placeEntity.getPlaceImageEntities())
		{
			Image img = new Image(placeImgEntity);
			this.getPlaceImages().add(img);
		}
	}
	
	//for trending places -- no need reviews
	public Place(PlaceEntity placeEntity, Long noOfReviews)
	{
		this.setPlaceId(placeEntity.getPlaceId());
		this.setName(placeEntity.getName());
		this.setAvgRating(placeEntity.getAvgRating());
		this.setCityId(placeEntity.getCityId());
		this.setDescription(placeEntity.getDescription());
		this.setPageViewCount(placeEntity.getPageViewCount());
		this.setNoOfReviews(noOfReviews);
		
		for(ImageEntity placeImgEntity : placeEntity.getPlaceImageEntities())
		{
			Image img = new Image(placeImgEntity);
			this.getPlaceImages().add(img);
		}
	}
	
	public Integer getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserReview> getReviews() {
		return reviews;
	}
	public void setReviews(List<UserReview> reviews) {
		this.reviews = reviews;
	} 
	public List<Image> getPlaceImages() {
		return placeImages;
	}
	public void setPlaceImages(List<Image> placeImages) {
		this.placeImages = placeImages;
	}
	public Integer getCityId() {
		return cityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Integer avgRating) {
		this.avgRating = avgRating;
	}

	public Integer getPageViewCount() {
		return pageViewCount;
	}

	public void setPageViewCount(Integer pageViewCount) {
		this.pageViewCount = pageViewCount;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Long getNoOfReviews() {
		return noOfReviews;
	}

	public void setNoOfReviews(Long noOfReviews) {
		this.noOfReviews = noOfReviews;
	}
}

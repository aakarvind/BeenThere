package beenthere.model;

import beenthere.entity.ImageEntity;

public class Image 
{
	private Integer imageId;
	private String imageBase64Str;
	
	private Integer reviewId;
	private Integer placeId;
	private Integer cityId;
	
	public Image(){}
	
	public Image(ImageEntity imgEntity){
		setImageBase64Str(imgEntity.getImageStr());
		setImageId(imgEntity.getImageId());
	}
	
	public Image(ImageInput imgInput){
		setImageBase64Str(imgInput.getBase64String());
		setCityId(imgInput.getCityId());
		setPlaceId(imgInput.getPlaceId());
		setReviewId(imgInput.getReviewId());
	}
	
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageBase64Str() {
		return imageBase64Str;
	}

	public void setImageBase64Str(String imageBase64Str) {
		this.imageBase64Str = imageBase64Str;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
}

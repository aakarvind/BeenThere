package beenthere.model;

public class ImageInput 
{
	private String base64String;
	private Integer reviewId;
	private Integer placeId;
	private Integer cityId;

	public Integer getPlaceId() {
		return placeId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public String getBase64String() {
		return base64String;
	}

	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

}

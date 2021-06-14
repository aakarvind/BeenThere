package beenthere.entity;

import java.util.ArrayList;
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

import beenthere.model.Place;

@Entity
@Table(name = "places")
@GenericGenerator(name = "placeIdGen", strategy = "increment")
public class PlaceEntity 
{
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
		PlaceEntity other = (PlaceEntity) obj;
		if (placeId == null) {
			if (other.placeId != null)
				return false;
		} else if (!placeId.equals(other.placeId))
			return false;
		return true;
	}

	@Id
	@Column(name = "p_id")
	@GeneratedValue(generator = "placeIdGen")
	private Integer placeId;
	
	@Column(name = "p_name")
	private String name;
	
	private String description;

	@Column(name = "avg_rating")
	private Integer avgRating;

	@Column(name = "page_request_count")
	private Integer pageViewCount;
	
	private Integer cityId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "placereviews",
		joinColumns = @JoinColumn(		//refers to origin table
					name = "place", // attr name in lookup(new) table
					referencedColumnName = "p_id" // attr name in originall data table
					),
		inverseJoinColumns = @JoinColumn(		//inverse refers to target table
					name = "review",		//attr name in lookup(new) table
					referencedColumnName = "review_Id",	// attr name in target table
					unique = true	//observe the table attr defn.. its mentioned
					)
		)
	private List<UserReviewEntity> reviewEntities;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "placeImages",
		joinColumns = @JoinColumn(		//refers to origin table
					name = "place", // attr name in lookup(new) table
					referencedColumnName = "p_id" // attr name in originall data table
					),
		inverseJoinColumns = @JoinColumn(		//inverse refers to target table
					name = "image",		//attr name in lookup(new) table
					referencedColumnName = "imageId",	// attr name in target table
					unique = true	//observe the table attr defn.. its mentioned
					)
		)
	private List<ImageEntity> placeImageEntities = new ArrayList<>();

	public PlaceEntity(){}
	
	public PlaceEntity(Place place)
	{
		setName(place.getName());
		setAvgRating(place.getAvgRating());
		setCityId(place.getCityId());
		setDescription(place.getDescription());
		setPageViewCount(place.getPageViewCount());
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

	public List<UserReviewEntity> getReviewEntities() {
		return reviewEntities;
	}

	public void setReviewEntities(List<UserReviewEntity> reviewEntities) {
		this.reviewEntities = reviewEntities;
	}
	
	public List<ImageEntity> getPlaceImageEntities() {
		return placeImageEntities;
	}

	public void setPlaceImageEntities(List<ImageEntity> placeImageEntities) {
		this.placeImageEntities = placeImageEntities;
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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
}

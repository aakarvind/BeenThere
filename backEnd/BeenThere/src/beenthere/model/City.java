package beenthere.model;

import java.util.ArrayList;
import java.util.List;

import beenthere.entity.CityEntity;
import beenthere.entity.ImageEntity;
import beenthere.entity.PlaceEntity;

public class City 
{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		City other = (City) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	private Integer cityId;
	private String name;
	private String description;
	private List<Place> places = new ArrayList<>();
	private List<Image> cityImages = new ArrayList<>();
	private String cityCreationImageString;
	
	public City(){}

	public City(CityEntity cityEntity)
	{
		this.setCityId(cityEntity.getCityId());
		this.setName(cityEntity.getName());
		this.setDescription(cityEntity.getDescription());
		
		for(PlaceEntity placeEntity: cityEntity.getPlaceEntities())
		{
			this.places.add(new Place(placeEntity));
		}
		
		for(ImageEntity cityImgEntity : cityEntity.getCityImageEntities())
		{
			Image img = new Image(cityImgEntity);
			this.getCityImages().add(img);
		}
	}
	
	
	public String getCityCreationImageString() {
		return cityCreationImageString;
	}

	public void setCityCreationImageString(String cityCreationImageString) {
		this.cityCreationImageString = cityCreationImageString;
	}

	public List<Image> getCityImages() {
		return cityImages;
	}

	public void setCityImages(List<Image> cityImages) {
		this.cityImages = cityImages;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
}

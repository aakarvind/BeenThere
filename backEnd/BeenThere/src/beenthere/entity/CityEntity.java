package beenthere.entity;

import java.util.*;

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

import beenthere.model.City;
import beenthere.model.Place;

@Entity
@Table(name = "cities")
@GenericGenerator(name = "cityIdGen", strategy = "increment")
public class CityEntity 
{
	@Id
	@Column(name = "c_id")
	@GeneratedValue(generator = "cityIdGen")
	private Integer cityId;
	
	@Column(name = "c_name")
	private String name;
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "cityplaces",
		joinColumns = @JoinColumn(		//refers to origin table
					name = "city", // attr name in lookup(new) table
					referencedColumnName = "c_id" // attr name in originall data table
					),
		inverseJoinColumns = @JoinColumn(		//inverse refers to target table
					name = "place",		//attr name in lookup(new) table
					referencedColumnName = "p_id",	// attr name in target table
					unique = true	//observe the table attr defn.. its mentioned
					)
		)
	private List<PlaceEntity> placeEntities = new ArrayList<>();
	
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
		CityEntity other = (CityEntity) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "cityImages",
		joinColumns = @JoinColumn(		//refers to origin table
					name = "city", // attr name in lookup(new) table
					referencedColumnName = "c_id" // attr name in originall data table
					),
		inverseJoinColumns = @JoinColumn(		//inverse refers to target table
					name = "image",		//attr name in lookup(new) table
					referencedColumnName = "imageId",	// attr name in target table
					unique = true	//observe the table attr defn.. its mentioned
					)
		)
	private List<ImageEntity> cityImageEntities = new ArrayList<>();

	public CityEntity(){}
	
	public CityEntity(City city)
	{
		this.setName(city.getName());
		this.setDescription(city.getDescription());
		
		for(Place place : city.getPlaces())
		{
			this.placeEntities.add(new PlaceEntity(place));
		}
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

	public List<PlaceEntity> getPlaceEntities() {
		return placeEntities;
	}

	public void setPlaceEntities(List<PlaceEntity> placeEntities) {
		this.placeEntities = placeEntities;
	}	
	
	public List<ImageEntity> getCityImageEntities() {
		return cityImageEntities;
	}

	public void setCityImageEntities(List<ImageEntity> cityImageEntities) {
		this.cityImageEntities = cityImageEntities;
	}

}

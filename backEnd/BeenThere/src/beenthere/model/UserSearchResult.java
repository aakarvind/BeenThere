package beenthere.model;

import java.util.HashSet;
import java.util.Set;

public class UserSearchResult {
	private Set<Place> matchingPlaces = new HashSet<>();
	private Set<City> matchingCities = new HashSet<>();
	
	public Set<Place> getMatchingPlaces() {
		return matchingPlaces;
	}
	public void setMatchingPlaces(Set<Place> matchingPlaces) {
		this.matchingPlaces = matchingPlaces;
	}
	public Set<City> getMatchingCities() {
		return matchingCities;
	}
	public void setMatchingCities(Set<City> matchingCities) {
		this.matchingCities = matchingCities;
	}
}

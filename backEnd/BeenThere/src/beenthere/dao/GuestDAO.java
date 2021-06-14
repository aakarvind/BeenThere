package beenthere.dao;

import java.util.List;

import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.Place;
import beenthere.model.UserReview;

public interface GuestDAO {

	List<Place> getPlacesInCity(Integer cityId);

	List<City> getAllCities();

	List<UserReview> getReviewsAboutPlace(Integer placeId);

	List<Place> getAllPlaces();

	Image insertImage(Image img);

	String getImage(Integer imageId);

	List<String> getAllCitiesAndPlacesList();

	List<String> getAllCityNamesList();

	List<String> getAllPlaceNamesInCity(Integer cityId);

	City getCityWithId(Integer cityId);

	Place getPlaceWithId(Integer placeID);

}

package beenthere.service;

import java.util.List;

import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.Place;
import beenthere.model.UserReview;

public interface GuestService {

	List<City> getAllCities() throws Exception;

	List<Place> getAllPlaces() throws Exception;

	List<Place> getPlacesInCity(Integer cityId) throws Exception;

	List<UserReview> getReviewsAboutPlace(Integer placeId) throws Exception;

	Image insertImage(Image img) throws Exception;

	String getImage(Integer imageId) throws Exception;

	List<String> getAllCitiesAndPlacesList() throws Exception;

	List<String> getAllCityNamesList() throws Exception;

	List<String> getAllPlaceNamesInCity(Integer cityId) throws Exception;

	City getCityWithId(Integer cityId) throws Exception;

	Place getPlaceWithId(Integer placeID) throws Exception;

}

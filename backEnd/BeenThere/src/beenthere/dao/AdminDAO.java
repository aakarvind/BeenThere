package beenthere.dao;

import java.util.List;

import beenthere.model.Admin;
import beenthere.model.AdminDashBoardData;
import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.LoginCredentials;
import beenthere.model.Place;
import beenthere.model.HelpdeskQuery;
import beenthere.model.SiteFeedback;
import beenthere.model.User;

public interface AdminDAO 
{
	Admin loginAdmin(LoginCredentials credentials);

	Place addPlace(Place place);

	City addCity(City city);

	Image insertImageForCity(Image img);

	Image insertImageForPlace(Image img);

	AdminDashBoardData adminDashboardData();

	City updateCity(City city);

	Place updatePlace(Place place);

	String deleteCity(Integer cityId);

	String deletePlace(Integer placeId);

	AdminDashBoardData getViewUsersComponentData();

	List<SiteFeedback> getAllFeedbacks();

	List<HelpdeskQuery> getAllUserQueries();

	User getUserByEmail(String userEmail);

	List<User> getUsersListByName(String userName);

	List<Place> getTrendingPlaces();

	List<Place> getMostSearchedPlaces();

}

package beenthere.service;

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

public interface AdminService {
	
	Admin loginAdmin(LoginCredentials credentials) throws Exception;

	Place addPlace(Place place) throws Exception;

	City addCity(City city) throws Exception;

	Image insertImageForCity(Image img) throws Exception;

	Image insertImageForPlace(Image img) throws Exception;

	AdminDashBoardData adminDashboardData() throws Exception;

	City updateCity(City city) throws Exception;

	Place updatePlace(Place place) throws Exception;

	String deleteCity(Integer cityId) throws Exception;

	String deletePlace(Integer placeId) throws Exception;

	AdminDashBoardData getViewUsersComponentData() throws Exception;

	List<SiteFeedback> getAllFeedbacks() throws Exception;

	List<HelpdeskQuery> getAllUserQueries() throws Exception;

	User getUserByEmail(String userEmail) throws Exception;

	List<User> getUsersListByName(String userName) throws Exception;

}

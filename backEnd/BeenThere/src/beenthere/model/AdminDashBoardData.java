package beenthere.model;

import java.util.ArrayList;
import java.util.List;

public class AdminDashBoardData {
	
	private List<Place> trendingPlace = new ArrayList<Place>();
	private List<Place> topSearchedPlaces = new ArrayList<Place>();
	private List<User> topContactedUsers = new ArrayList<User>();
	private List<User> topTravellingUsers = new ArrayList<User>();
	private Integer satisfactionLevel;
	private Integer helpdeskStatus;
	private List<String> userNamesForSearch = new ArrayList<>();
	private String errorMessage;
	
	public List<String> getUserNamesForSearch() {
		return userNamesForSearch;
	}
	public void setUserNamesForSearch(List<String> userNamesForSearch) {
		this.userNamesForSearch = userNamesForSearch;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<Place> getTrendingPlace() {
		return trendingPlace;
	}
	public void setTrendingPlace(List<Place> trendingPlace) {
		this.trendingPlace = trendingPlace;
	}
	public List<Place> getTopSearchedPlaces() {
		return topSearchedPlaces;
	}
	public void setTopSearchedPlaces(List<Place> topSearchedPlaces) {
		this.topSearchedPlaces = topSearchedPlaces;
	}
	public List<User> getTopContactedUsers() {
		return topContactedUsers;
	}
	public void setTopContactedUsers(List<User> topContactedUsers) {
		this.topContactedUsers = topContactedUsers;
	}
	public Integer getSatisfactionLevel() {
		return satisfactionLevel;
	}
	public void setSatisfactionLevel(Integer satisfactionLevel) {
		this.satisfactionLevel = satisfactionLevel;
	}
	public Integer getHelpdeskStatus() {
		return helpdeskStatus;
	}
	public void setHelpdeskStatus(Integer helpdeskStatus) {
		this.helpdeskStatus = helpdeskStatus;
	}
	public List<User> getTopTravellingUsers() {
		return topTravellingUsers;
	}
	public void setTopTravellingUsers(List<User> topTravellingUsers) {
		this.topTravellingUsers = topTravellingUsers;
	}
}

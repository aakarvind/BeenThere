package beenthere.model;

import java.util.ArrayList;
import java.util.List;

public class UserHomeData {
	private List<Place> trendingPlace = new ArrayList<Place>();
	private List<Place> topSearchedPlaces = new ArrayList<Place>();
	private List<SiteFeedback> topSiteFeedbacks = new ArrayList<>();
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
	public List<SiteFeedback> getTopSiteFeedbacks() {
		return topSiteFeedbacks;
	}
	public void setTopSiteFeedbacks(List<SiteFeedback> topSiteFeedbacks) {
		this.topSiteFeedbacks = topSiteFeedbacks;
	}
}

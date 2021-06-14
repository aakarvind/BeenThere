package beenthere.service;

import java.util.List;

import beenthere.model.Image;
import beenthere.model.LoginCredentials;
import beenthere.model.Messgaes;
import beenthere.model.HelpdeskQuery;
import beenthere.model.SiteFeedback;
import beenthere.model.User;
import beenthere.model.UserHomeData;
import beenthere.model.UserReview;
import beenthere.model.UserSearchResult;

public interface UserService 
{
	User registerUser(User user) throws Exception;
	
	User loginUser(LoginCredentials credentials) throws Exception;

	UserReview addUserReview(UserReview userReview) throws Exception;

	Image insertImageForReview(Image img) throws Exception;

	List<Messgaes> recive(Messgaes msg) throws Exception;

	Messgaes store(Messgaes msg) throws Exception;

	List<User> getAllUsers() throws Exception;

	SiteFeedback addSiteFeedback(SiteFeedback siteFeedback) throws Exception;

	HelpdeskQuery raiseQuery(HelpdeskQuery queryModel) throws Exception;

	UserSearchResult getSearchResultObjects(String searchStr) throws Exception;

	UserHomeData userHomePageData() throws Exception;
}

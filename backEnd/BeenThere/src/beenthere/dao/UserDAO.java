package beenthere.dao;

import java.util.List;

import beenthere.model.HelpdeskQuery;
import beenthere.model.Image;
import beenthere.model.LoginCredentials;
import beenthere.model.Messgaes;
import beenthere.model.SiteFeedback;
import beenthere.model.User;
import beenthere.model.UserHomeData;
import beenthere.model.UserReview;
import beenthere.model.UserSearchResult;

public interface UserDAO 
{
	User registerUser(User user);
	
	User loginUser(LoginCredentials credentials);

	UserReview addUserReview(UserReview userReview);

	Image insertImageForReview(Image img);

	List<User> getAllUsers() throws Exception;

	Messgaes store(Messgaes msg);

	List<Messgaes> recive(Messgaes msg);

	SiteFeedback addSiteFeedback(SiteFeedback siteFeedback);

	HelpdeskQuery raiseQuery(HelpdeskQuery queryModel);

	UserSearchResult getSearchResultObjects(String searchStr);

	UserHomeData userHomePageData();
}

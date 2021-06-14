package beenthere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beenthere.dao.AdminDAO;
import beenthere.dao.UserDAO;
import beenthere.model.HelpdeskQuery;
import beenthere.model.Image;
import beenthere.model.LoginCredentials;
import beenthere.model.Messgaes;
import beenthere.model.Place;
import beenthere.model.SiteFeedback;
import beenthere.model.User;
import beenthere.model.UserHomeData;
import beenthere.model.UserReview;
import beenthere.model.UserSearchResult;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService  
{
	/*
	 * 0. annotaions and dao:
	 * -> @Service("adminLoginService")
	 * 	  @Transactional(readOnly = true)
	 * 
	 * -> @Autowired
	 * 	  private AdminLoginDAO adminLoginDao;
	 * 
	 * Methods:
	 * 1. transactional readonly:
	 *   get 					-> readOnly = false
	 *   insert, update, delete -> readOnly = true // it is default no need to mention again
	 *   
	 * 2. handle exception:
	 *   throws Exception
	 *   
	 * 3. call respective dao method and store result
	 * 	 obj = dao.method()
	 * 
	 * 4. check for corner cases/ nulls:
	 * 	 guard by 	-> if(obj !=/== null)
	 *   finally return model obj -> obj
	 */
	@Autowired
	private UserDAO userDao;
	@Autowired
	private AdminDAO adminDao;

	@Override
	public UserHomeData userHomePageData() throws Exception {
		UserHomeData data = userDao.userHomePageData();
		
		int count = 0;
		for(Place place: adminDao.getTrendingPlaces()){
			if(count < 3){
				count ++;
				data.getTrendingPlace().add(place);
			}
		}
		
		count = 0;
		for(Place place: adminDao.getMostSearchedPlaces()){
			if(count < 3){
				count ++;
				data.getTopSearchedPlaces().add(place);
			}
		}
		
		count = 0;
		boolean isUserIdPresent = false;
		for(SiteFeedback feedback: adminDao.getAllFeedbacks()){
			if(count < 3){
				if(feedback.getSatisfactionLevel() >= 3 && feedback.getSatisfactionLevel() <= 5){
					isUserIdPresent = false;
					for(SiteFeedback already: data.getTopSiteFeedbacks()){
						if(already.getUserId().equals(feedback.getUserId())){
							isUserIdPresent = true;
							break;
						}
					}
					if(!isUserIdPresent){
						data.getTopSiteFeedbacks().add(feedback);
						count ++;
					}
				}
			}
		}
		
		return data;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public User registerUser(User user) throws Exception 
	{
		User resultUser = userDao.registerUser(user);
		
		if( resultUser == null )
			throw new Exception("Service.USER_ALREADY_EXISTS");
		
		return resultUser;
	}

	@Override
	public User loginUser(LoginCredentials credentials) throws Exception 
	{
		User user = userDao.loginUser(credentials);
		
		if( user == null )
			throw new Exception("Service.INVALID_USER_CREDENTIALS");
		
		return user;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public UserReview addUserReview(UserReview userReview) throws Exception
	{
		UserReview addedUserReview = userDao.addUserReview(userReview);
		return addedUserReview;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public SiteFeedback addSiteFeedback(SiteFeedback siteFeedback) throws Exception
	{
		SiteFeedback addedSiteFeedback = userDao.addSiteFeedback(siteFeedback);
		return addedSiteFeedback;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public HelpdeskQuery raiseQuery(HelpdeskQuery queryModel) throws Exception
	{
		HelpdeskQuery addedQuery = userDao.raiseQuery(queryModel);
		return addedQuery;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Image insertImageForReview(Image img) throws Exception
	{
		Image insertedImage = userDao.insertImageForReview(img);
		
		return insertedImage;
	}

	@Override
	public UserSearchResult getSearchResultObjects(String searchStr) throws Exception
	{
		UserSearchResult result = userDao.getSearchResultObjects(searchStr);
		
		return result;
	}
	
	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public List<Messgaes> recive(Messgaes msg)throws Exception
	{
		List<Messgaes> log= userDao.recive(msg);

		if(log==null){
			throw new Exception("Internal Error");
		}
		return log;
		
		
		
		
	}

	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public Messgaes store(Messgaes msg)throws Exception
	{
		Messgaes log= userDao.store(msg);

		if(log==null){
			throw new Exception("Internal Error");
		}
		return log;
		
	}
	
	@Override
	@Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
	public List<User> getAllUsers() throws Exception {
		List<User> listOfUsers= userDao.getAllUsers();
		if(listOfUsers.size()<=0){
			throw new Exception("No Users available");
		}
		return listOfUsers;
	}
	

}

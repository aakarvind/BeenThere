package beenthere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beenthere.dao.AdminDAO;
import beenthere.model.Admin;
import beenthere.model.AdminDashBoardData;
import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.LoginCredentials;
import beenthere.model.Place;
import beenthere.model.HelpdeskQuery;
import beenthere.model.SiteFeedback;
import beenthere.model.User;

@Service("adminService")
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService 
{
	/*
	 * 0. annotaions and dao:
	 * -> @Service("adminLoginService")
	 * 	  @Transactional(readOnly = true)
	 * 
	 * 	  **Import from org.springframework.
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
	private AdminDAO adminDao;
	
	@Override
	public Admin loginAdmin(LoginCredentials credentials) throws Exception {
		Admin admin = adminDao.loginAdmin(credentials);
		if(admin == null)
			throw new Exception("Service.INVALID_ADMIN_CREDENTIALS");
		return admin;
	}
	
	@Override
	public AdminDashBoardData adminDashboardData() throws Exception {
		AdminDashBoardData data = adminDao.adminDashboardData();
//		if(data == null)
//			throw new Exception("Service.INVALID_ADMIN_CREDENTIALS");
		return data;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Place addPlace(Place place) throws Exception
	{
		Place addedPlace = adminDao.addPlace(place);
		return addedPlace;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public City addCity(City city) throws Exception
	{
		City addedCity = adminDao.addCity(city);
		return addedCity;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Image insertImageForCity(Image img) throws Exception
	{
		Image insertedImage = adminDao.insertImageForCity(img);
		
		return insertedImage;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Image insertImageForPlace(Image img) throws Exception
	{
		Image insertedImage = adminDao.insertImageForPlace(img);
		
		return insertedImage;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public City updateCity(City city) throws Exception
	{
		City updatedCity = adminDao.updateCity(city);
		return updatedCity;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Place updatePlace(Place place) throws Exception
	{
		Place updatedPlace = adminDao.updatePlace(place);
		return updatedPlace;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public String deleteCity(Integer cityId) throws Exception
	{
		String result = adminDao.deleteCity(cityId);
		return result;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public String deletePlace(Integer placeId) throws Exception
	{
		String result = adminDao.deletePlace(placeId);
		return result;
	}
	
	@Override
	public AdminDashBoardData getViewUsersComponentData() throws Exception {
		AdminDashBoardData data = adminDao.getViewUsersComponentData();
		return data;
	}
	
	@Override
	public List<SiteFeedback> getAllFeedbacks() throws Exception
	{
		List<SiteFeedback> allFeedbacks = adminDao.getAllFeedbacks();
		
		if(allFeedbacks.size() == 0)
		{
			throw new Exception("No Feedbacks found");
		}
		
		return allFeedbacks;
	}
	
	@Override
	public List<HelpdeskQuery> getAllUserQueries() throws Exception
	{
		List<HelpdeskQuery> allUserQueries = adminDao.getAllUserQueries();
		
		if(allUserQueries.size() == 0)
		{
			throw new Exception("No Feedbacks found");
		}
		
		return allUserQueries;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public User getUserByEmail(String userEmail) throws Exception
	{
		User user = adminDao.getUserByEmail(userEmail);
		return user;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public List<User> getUsersListByName(String userName) throws Exception
	{
		List<User> userList = adminDao.getUsersListByName(userName);
		return userList;
	}
	
}

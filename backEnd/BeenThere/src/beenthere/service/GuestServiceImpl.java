package beenthere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beenthere.dao.GuestDAO;
import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.Place;
import beenthere.model.UserReview;

@Service("guestService")
@Transactional(readOnly = true)
public class GuestServiceImpl implements GuestService 
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
	private GuestDAO guestDao;
	
	@Override
	public List<City> getAllCities() throws Exception
	{
		List<City> allCities = guestDao.getAllCities();
		
		if(allCities.size() == 0)
		{
			throw new Exception("No Cities found");
		}
		
		return allCities;
	}
	
	@Override
	public List<Place> getAllPlaces() throws Exception
	{
		List<Place> allPlaces = guestDao.getAllPlaces();
		
		if(allPlaces.size() == 0)
		{
			throw new Exception("No Places found");
		}
		
		return allPlaces;
	}
	
	@Override
	public List<Place> getPlacesInCity(Integer cityId) throws Exception
	{
		List<Place> allPlacesInCity = guestDao.getPlacesInCity(cityId);
		
		if(allPlacesInCity == null || allPlacesInCity.size() == 0)
		{
			throw new Exception("No Places found in given City");
		}
		
		return allPlacesInCity;
	}
	
	@Override
	public List<UserReview> getReviewsAboutPlace(Integer placeId) throws Exception
	{
		List<UserReview> allReviewsAboutPlace = guestDao.getReviewsAboutPlace(placeId);
		
		if(allReviewsAboutPlace == null || allReviewsAboutPlace.size() == 0)
		{
			throw new Exception("No Reviews found about given Place");
		}
		
		return allReviewsAboutPlace;
	}
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Image insertImage(Image img) throws Exception
	{
		Image insertedImage = guestDao.insertImage(img);
		
		return insertedImage;
	}
	
	@Override
	public String getImage(Integer imageId) throws Exception
	{
		String base64Url = guestDao.getImage(imageId);
		
		return base64Url;
	}
	
	@Override
	public List<String> getAllCitiesAndPlacesList() throws Exception
	{
		List<String> allCitiesAndPlacesList = guestDao.getAllCitiesAndPlacesList();
		
		if(allCitiesAndPlacesList.size() == 0)
		{
			throw new Exception("No Cities found");
		}
		
		return allCitiesAndPlacesList;
	}
	
	@Override
	public List<String> getAllCityNamesList() throws Exception
	{
		List<String> allCityNames = guestDao.getAllCityNamesList();
		
		if(allCityNames.size() == 0)
		{
			throw new Exception("No Cities found");
		}
		
		return allCityNames;
	}
	
	@Override
	public List<String> getAllPlaceNamesInCity(Integer cityId) throws Exception
	{
		List<String> allPlaceNamesInCity = guestDao.getAllPlaceNamesInCity(cityId);
		
		if(allPlaceNamesInCity == null || allPlaceNamesInCity.size() == 0)
		{
			throw new Exception("No Places found in given City");
		}
		
		return allPlaceNamesInCity;
	}
	
	@Override
	public City getCityWithId(Integer cityId) throws Exception
	{
		City city = guestDao.getCityWithId(cityId);
		
		if(city == null)
		{
			throw new Exception("No Places found in given City");
		}
		
		return city;
	}
	
	@Override
	public Place getPlaceWithId(Integer placeID) throws Exception
	{
		Place place = guestDao.getPlaceWithId(placeID);
		
		if(place == null)
		{
			throw new Exception("No Places found in given City");
		}
		
		return place;
	}
	
}

package beenthere.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import beenthere.entity.CityEntity;
import beenthere.entity.ImageEntity;
import beenthere.entity.PlaceEntity;
import beenthere.entity.UserReviewEntity;
import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.Place;
import beenthere.model.UserReview;

@Repository("guestDao")
public class GuestDAOImpl implements GuestDAO 
{
	/*
	 * 0. annotaions and sessionFactory
	 * -> @Repository("adminDao")
	 * 
	 * -> @Autowired
	 *    SessionFactory sessionFactory;
	 * 
	 * methods:
	 * 	1. get current session
	 * 	Session session = sessionFactory.getCurrentSession();
	 *  
	 *  2. create the entity for operations
	 *  
	 *  3. perform the required operations to get required obj( in EntityType)
	 *  
	 *  4. check for null and convert to modelObj
	 *  
	 *  5. return the modelObj
	 */
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<City> getAllCities()
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<City> allCities = new ArrayList<>();
		
		Query qry = session.createQuery("select city from CityEntity city");
		
		@SuppressWarnings("unchecked")
		List<CityEntity> allCityEntities = qry.list();
		
		for(CityEntity cityEntity : allCityEntities)
		{
			City currCity = new City(cityEntity);
			allCities.add(currCity);
		}
		return allCities;
	}
	
	@Override
	public List<Place> getAllPlaces()
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<Place> allPlaces = new ArrayList<Place>();
		
		Query qry = session.createQuery("select place from PlaceEntity place");
		
		@SuppressWarnings("unchecked")
		List<PlaceEntity> allPlaceEntities = qry.list();
		
		for(PlaceEntity placeEntity : allPlaceEntities)
		{
			Place currPlace = new Place(placeEntity);
			allPlaces.add(currPlace);
		}
		return allPlaces;
	}

	@Override
	public List<Place> getPlacesInCity(Integer cityId)
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<Place> allPlacesInCity = null;
		
		CityEntity cityEntity = session.get(CityEntity.class, cityId);
		
		if(cityEntity != null)
		{
			City city = new City(cityEntity);
			
			allPlacesInCity = city.getPlaces();
		}
		
		return allPlacesInCity;
	}
	
	@Override
	public List<UserReview> getReviewsAboutPlace(Integer placeId)
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<UserReview> allReviewsAboutPlace = null;
		
		PlaceEntity placeEntity = session.get(PlaceEntity.class, placeId);
		
		if(placeEntity != null)
		{
			Place place = new Place(placeEntity);
			
			allReviewsAboutPlace = place.getReviews();
		}
		
		return allReviewsAboutPlace;
	}
	
	@Override
	public List<String> getAllCitiesAndPlacesList()
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<String> allCitiesAndPlacesList = new ArrayList<>();
		
		Query qry = session.createQuery("select city from CityEntity city");
		
		@SuppressWarnings("unchecked")
		List<CityEntity> allCityEntities = qry.list();
		
		String temp = null;
		for(CityEntity cityEntity : allCityEntities)
		{
			temp = "C:" + cityEntity.getCityId() + ":" + cityEntity.getName();
			allCitiesAndPlacesList.add(temp);
			
			for(PlaceEntity placeEntity : cityEntity.getPlaceEntities())
			{
				temp = "P:" + placeEntity.getPlaceId() + ":" + placeEntity.getName();
				allCitiesAndPlacesList.add(temp);
			}
		}
		return allCitiesAndPlacesList;
	}

	@Override
	public List<String> getAllCityNamesList()
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<String> allCityNames = new ArrayList<>();
		
		Query qry = session.createQuery("select city from CityEntity city");
		
		@SuppressWarnings("unchecked")
		List<CityEntity> allCityEntities = qry.list();
		
		String temp;
		for(CityEntity cityEntity : allCityEntities)
		{
			temp = "";
			temp = "C:" + cityEntity.getCityId() + ":" + cityEntity.getName();
			allCityNames.add(temp);
		}
		return allCityNames; 
	}
	
	@Override
	public List<String> getAllPlaceNamesInCity(Integer cityId)
	{
		Session session = sessionFactory.getCurrentSession();
		
		List<String> allPlaceNamesInCity = new ArrayList<>();
		
		CityEntity cityEntity = session.get(CityEntity.class, cityId);
		
		if(cityEntity != null)
		{
			String temp;
			for(PlaceEntity placeEntity : cityEntity.getPlaceEntities())
			{
				temp = "";
				temp = "P:" + placeEntity.getPlaceId() + ":" + placeEntity.getName();
				allPlaceNamesInCity.add(temp);
			}
		}
		
		return allPlaceNamesInCity;
	}
	
	@Override
	public City getCityWithId(Integer cityId)
	{
		Session session = sessionFactory.getCurrentSession();
		
		City city = null;
		
		CityEntity cityEntity = session.get(CityEntity.class, cityId);
		
		if(cityEntity != null)
		{
			city = new City(cityEntity);
		}
		
		return city;
	}
	
	@Override
	public Place getPlaceWithId(Integer placeID)
	{
		Session session = sessionFactory.getCurrentSession();
		
		Place place = null;
		
		PlaceEntity placeEntity = session.get(PlaceEntity.class, placeID);
		
		if(placeEntity != null)
		{
			place = new Place(placeEntity);
		}
		
		return place;
	}
	
	//extras -- test
	@Override
	public Image insertImage(Image img)
	{
		Session session = sessionFactory.getCurrentSession();
		
		ImageEntity imgEntity = new ImageEntity(img);
		System.out.println(img.getReviewId());
		UserReviewEntity reviewEntity = session.get(UserReviewEntity.class, img.getReviewId());
//        System.out.println(session.save(imgEntity));
		reviewEntity.getImageEntities().add(imgEntity);
        System.out.println(session.save(reviewEntity));
        
//        System.out.println(imgEntity.getImageId());
        img.setImageId(imgEntity.getImageId());
		return img;
	}
	
	@Override
	public String getImage(Integer imageId)
	{
		//https://www.baeldung.com/java-base64-image-string
		
		Session session = sessionFactory.getCurrentSession();
		
		ImageEntity imgEntity = session.get(ImageEntity.class, imageId);
        
//		System.out.println(imageId);
//		System.out.println(imgEntity.getImageId());
//		System.out.println(imgEntity.getImage());
		
        Image img = new Image(imgEntity);
//		System.out.println(img.getPic());
		
		return img.getImageBase64Str();
	}
	
}

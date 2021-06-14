package beenthere.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.ImageInput;
import beenthere.model.Place;
import beenthere.model.UserReview;
import beenthere.service.AdminService;
import beenthere.service.AdminServiceImpl;
import beenthere.service.GuestService;
import beenthere.service.GuestServiceImpl;
import beenthere.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="guest")
public class GuestAPI 
{
	/*
	 * 0.1. annotations:
	 * @RestController
	 * @CrossOrigin
	 * @RequestMapping(value="admin")
	 * 
	 * 0.2. service injected (without the @autowired)
	 * in class
	 * -> private SeaQueenBoatsService seaQueenBoatsService;
	 * -> similarly any other services needed to be given here
	 * 
	 * Methods:
	 * 1. returnType should be ResponseEntity<>:
	 *   ResponseEntity<model>
	 *   or
	 *   ResponseEntity<List<model>>
	 *   
	 * 2. RequestMapping && (RequestBody || PathVariable):
	 *   @RequestMapping(method=RequestMethod.PUT, value="boatUpdate")
	 *     &  (@RequestBody Boat boatToUpdate)
	 *     
	 *   or
	 *   
	 *   @RequestMapping(method=RequestMethod.GET, value="boatsAll")
	 *     &  ()
	 *     
	 *   or
	 *   
	 *   @RequestMapping(method=RequestMethod.GET, value="boatDetail/{boatID}")
	 *     &  (@PathVariable("boatID") String boatId)
	 *     
	 * 3. Environment, Service, ResponseEntity(null), Model(null):
	 * Environment environment= ContextFactory.getContext().getEnvironment();
	 * //this is already given above service(here 'seaQueenBoatsService')
	 * aboveService = (AboveService) ContextFactory.getContext().getBean(AboveServiceImpl.class); 
	 * 
	 * ResponseEntity<Admin> responseEntity=null;
	 * Admin admin = null;
	 * 
	 * 4. try-catch, log & servicemethod calls:
	 * try{
	 * 		get model obj by method call on service
	 * 		set responseEntity by -> responseEntity = new ResponseEntity<>(admin, HttpStatus.OK);
	 * }
	 * catch(E e){
	 *  	get error message from environment by 
	 *  		-> String errorMessage = environment.getProperty(exception.getMessage());
	 * 		new model obj
	 *  	set error message into new obj
	 *  	set responseEntity by 
	 *  		-> responseEntity = new ResponseEntity<>(admin, HttpStatus.BAD_REQUEST);
	 * }
	 *  
	 * 5. return responseEntity
	 */
	
	private GuestService guestService;
	
//	NEEDED FOR SEARCH BAR
	@RequestMapping(method=RequestMethod.GET, value="getAllCitiesAndPlacesList")
	public ResponseEntity<List<String>> getAllCitiesAndPlacesList()
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<String>> responseEntity = null;
		List<String> allCitiesAndPlacesList = null;
		
		try
		{
			allCitiesAndPlacesList = guestService.getAllCitiesAndPlacesList();
			responseEntity = new ResponseEntity<>(allCitiesAndPlacesList, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allCitiesAndPlacesList = new ArrayList<String>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<String>>(allCitiesAndPlacesList, HttpStatus.BAD_REQUEST);
		} 
		
		return responseEntity;
	}
	
//	NEEDED FOR ADDING, UPDATING & DELETING PLACE(ADMIN) AND REVIEW(USER)
	@RequestMapping(method=RequestMethod.GET, value="getAllCityNamesList")
	public ResponseEntity<List<String>> getAllCityNamesList()
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<String>> responseEntity = null;
		List<String> allCityNames = null;

		try
		{
			allCityNames = guestService.getAllCityNamesList();
			responseEntity = new ResponseEntity<>(allCityNames, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allCityNames = new ArrayList<String>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<String>>(allCityNames, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
//	NEEDED FOR ADDING, UPDATING & DELETING PLACE(ADMIN) AND REVIEW(USER)
	@RequestMapping(method=RequestMethod.GET, value="getAllPlaceNamesInCity/{cityID}")
	public ResponseEntity<List<String>> getAllPlaceNamesInCity(@PathVariable("cityID") Integer cityId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<String>> responseEntity = null;
		List<String> allPlaceNames = null;

		try
		{
			allPlaceNames = guestService.getAllPlaceNamesInCity(cityId);
			responseEntity = new ResponseEntity<>(allPlaceNames, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allPlaceNames = new ArrayList<String>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<String>>(allPlaceNames, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
//	ALL CITIES WITH MAPPED PLACES(inturn mapped), IMAGES
	@RequestMapping(method=RequestMethod.GET, value="getAllCities")
	public ResponseEntity<List<City>> getAllCities()
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<City>> responseEntity = null;
		List<City> allCities = null;
		
		try
		{
			allCities = guestService.getAllCities();
			responseEntity = new ResponseEntity<>(allCities, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allCities = new ArrayList<City>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<City>>(allCities, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	ALL PLACES WITH ALL MAPPED REVIEWS, IMAGES
	@RequestMapping(method=RequestMethod.GET, value="getAllPlaces")
	public ResponseEntity<List<Place>> getAllPlaces()
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<Place>> responseEntity = null;
		List<Place> allPlaces = null;
		
		try
		{
			allPlaces = guestService.getAllPlaces();
			responseEntity = new ResponseEntity<>(allPlaces, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allPlaces = new ArrayList<Place>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<Place>>(allPlaces, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	GET PARTICULAR CITY WITH ID
	@RequestMapping(method=RequestMethod.GET, value="getCityWithId/{cityID}")
	public ResponseEntity<City> getCityWithId(@PathVariable("cityID") Integer cityId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<City> responseEntity = null;
		City city = null;

		try
		{
			city = guestService.getCityWithId(cityId);
			responseEntity = new ResponseEntity<>(city, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			city = new City();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<>(city, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
//	GET PARTICULAR CITY WITH ID
	@RequestMapping(method=RequestMethod.GET, value="getPlaceWithId/{placeID}")
	public ResponseEntity<Place> getPlaceWithId(@PathVariable("placeID") Integer placeId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<Place> responseEntity = null;
		Place place = null;

		try
		{
			place = guestService.getPlaceWithId(placeId);
			responseEntity = new ResponseEntity<>(place, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			place = new Place();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<>(place, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
//	PLACES IN A PARTICULAR CITY WITH ALL MAPPED REVIEWS, IMAGES
	@RequestMapping(method=RequestMethod.GET, value="getPlacesInCity/{cityID}")
	public ResponseEntity<List<Place>> getPlacesInCity(@PathVariable("cityID") Integer cityId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<Place>> responseEntity = null;
		List<Place> allPlacesInCity = null;
		
		try
		{
			allPlacesInCity = guestService.getPlacesInCity(cityId);
			responseEntity = new ResponseEntity<>(allPlacesInCity, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allPlacesInCity = new ArrayList<Place>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<Place>>(allPlacesInCity, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	REVIEWS ABOUT A PARTICULAR PLACE 
	@RequestMapping(method=RequestMethod.GET, value="getReviewsAboutPlace/{placeID}")
	public ResponseEntity<List<UserReview>> getReviewsAboutPlace(@PathVariable("placeID") Integer placeId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<List<UserReview>> responseEntity = null;
		List<UserReview> allReviewsAboutPlace = null;
		
		try
		{
			allReviewsAboutPlace = guestService.getReviewsAboutPlace(placeId);
			responseEntity = new ResponseEntity<>(allReviewsAboutPlace, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allReviewsAboutPlace = new ArrayList<UserReview>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<List<UserReview>>(allReviewsAboutPlace, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//EXTRAS -- FOR TESTING
	@RequestMapping(method=RequestMethod.POST, value="insertImage")
	public ResponseEntity<Image> insertImage(@RequestBody ImageInput imgStr)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		System.out.println("base64 received: " + imgStr.getBase64String());
		
		Image img = new Image(imgStr);
		
		ResponseEntity<Image> responseEntity = null;
		Image insertedImage = null;
        
		try
		{
			insertedImage = guestService.insertImage(img);
			responseEntity = new ResponseEntity<>(insertedImage, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			insertedImage = new Image();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<Image>(insertedImage, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	//EXTRAS -- FOR TESTING
	@RequestMapping(method=RequestMethod.GET, value="getImageById/{imageId}")
	public ResponseEntity<String> getImageById(@PathVariable Integer imageId)
	{
		guestService = (GuestService) ContextFactory.getContext().getBean(GuestServiceImpl.class);
		
		ResponseEntity<String> responseEntity = null;
		String base64Url = null;
		
		try
		{
			base64Url = guestService.getImage(imageId);
			System.out.println("sending imgUrl: " + base64Url);
			responseEntity = new ResponseEntity<>(base64Url, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			base64Url = "data:image/png;base64,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";
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<>(base64Url, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
}

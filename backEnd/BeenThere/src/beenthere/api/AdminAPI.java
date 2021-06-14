package beenthere.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beenthere.model.Admin;
import beenthere.model.AdminDashBoardData;
import beenthere.model.City;
import beenthere.model.Image;
import beenthere.model.ImageInput;
import beenthere.model.LoginCredentials;
import beenthere.model.Place;
import beenthere.model.HelpdeskQuery;
import beenthere.model.SiteFeedback;
import beenthere.model.User;
import beenthere.service.AdminService;
import beenthere.service.AdminServiceImpl;
import beenthere.service.GuestService;
import beenthere.service.GuestServiceImpl;
import beenthere.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="admin")
public class AdminAPI 
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
	
	private AdminService adminService;
	
//	ADMIN LOGIN
	@RequestMapping(method=RequestMethod.POST, value="adminLogin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody LoginCredentials credentials)
	{
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<Admin> responseEntity = null;
		Admin admin = null;
		
		try 
		{
			admin = adminService.loginAdmin(credentials);
			responseEntity = new ResponseEntity<>(admin, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			admin = new Admin();
			admin.setName(errorMessage);
			responseEntity = new ResponseEntity<>(admin, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	ADMIN DASHBOARD NEEDED DETAILS
	@RequestMapping(method=RequestMethod.GET, value="adminDashBoardData")
	public ResponseEntity<AdminDashBoardData> adminDashboardData()
	{
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<AdminDashBoardData> responseEntity = null;
		AdminDashBoardData data = null;
		
		try 
		{
			data = adminService.adminDashboardData();
			responseEntity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			data = new AdminDashBoardData();
			data.setErrorMessage(errorMessage);
			responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//ADD CITY (with out without Image)
	@RequestMapping(method=RequestMethod.POST, value="addCity")
	public ResponseEntity<City> addCity(@RequestBody City city)
	{
//		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<City> responseEntity = null;
		City addedCity = null;
		
		try
		{
			addedCity = adminService.addCity(city);
			if(city.getCityCreationImageString() != null){
				ImageInput imgIp = new ImageInput();
				imgIp.setCityId(addedCity.getCityId());
				imgIp.setBase64String(city.getCityCreationImageString());
				Image imgForCity = new Image(imgIp);
				adminService.insertImageForCity(imgForCity);
			}
			responseEntity = new ResponseEntity<>(addedCity, HttpStatus.OK);
		}
		catch(Exception exception)
		{
//			String errorMessage = environment.getProperty(exception.getMessage());
//			addedCity = new Place();
//			addedPlace.setName(errorMessage);
			responseEntity = new ResponseEntity<>(city, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//ADD PLACE IN AN EXISTING CITY (with out without Image)
	@RequestMapping(method=RequestMethod.POST, value="addPlace")
	public ResponseEntity<Place> addPlace(@RequestBody Place place)
	{
//		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<Place> responseEntity = null;
		Place addedPlace = null;
		
		try
		{
			addedPlace = adminService.addPlace(place);
			if(place.getPlaceCreationImageString() != null){
				ImageInput imgIp = new ImageInput();
				imgIp.setPlaceId(addedPlace.getPlaceId());
				imgIp.setBase64String(place.getPlaceCreationImageString());
				Image imgForPlace = new Image(imgIp);
				adminService.insertImageForPlace(imgForPlace);
			}
			responseEntity = new ResponseEntity<>(addedPlace, HttpStatus.OK);
		}
		catch(Exception exception)
		{
//			String errorMessage = environment.getProperty(exception.getMessage());
//			addedPlace = new Place();
//			addedPlace.setName(errorMessage);
			responseEntity = new ResponseEntity<>(place, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	//ADD IMAGE FOR CITY
	@RequestMapping(method=RequestMethod.POST, value="insertImageForCity")
	public ResponseEntity<Image> insertImageForCity(@RequestBody ImageInput imgStr)
	{
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		//System.out.println("base64 received: " + imgStr.getBase64String());
		Image img = new Image(imgStr);
		
		ResponseEntity<Image> responseEntity = null;
		Image insertedImage = null;
        
		try
		{
			insertedImage = adminService.insertImageForCity(img);
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
	
	//ADD IMAGE FOR PLACE
	@RequestMapping(method=RequestMethod.POST, value="insertImageForPlace")
	public ResponseEntity<Image> insertImageForPlace(@RequestBody ImageInput imgStr)
	{
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		//System.out.println("base64 received: " + imgStr.getBase64String());
		Image img = new Image(imgStr);
		
		ResponseEntity<Image> responseEntity = null;
		Image insertedImage = null;
        
		try
		{
			insertedImage = adminService.insertImageForPlace(img);
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
	
	//UPDATE CITY
	@RequestMapping(method=RequestMethod.POST, value="updateCity")
	public ResponseEntity<City> updateCity(@RequestBody City city)
	{
		//			Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);

		ResponseEntity<City> responseEntity = null;
		City updatedCity = null;

		try
		{
			updatedCity = adminService.updateCity(city);
			responseEntity = new ResponseEntity<>(updatedCity, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			responseEntity = new ResponseEntity<>(city, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
	//UPDATE PLACE
	@RequestMapping(method=RequestMethod.POST, value="updatePlace")
	public ResponseEntity<Place> updatePlace(@RequestBody Place place)
	{
		//			Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);

		ResponseEntity<Place> responseEntity = null;
		Place updatedPlace = null;

		try
		{
			updatedPlace = adminService.updatePlace(place);
			responseEntity = new ResponseEntity<>(updatedPlace, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			responseEntity = new ResponseEntity<>(place, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	//DELETE CITY
	@RequestMapping(method=RequestMethod.GET, value="deleteCity/{cityID}")
	public ResponseEntity<String> deleteCity(@PathVariable("cityID") Integer cityId)
	{
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);

		ResponseEntity<String> responseEntity = null;
		String result = null;
		
		try
		{
			result = adminService.deleteCity(cityId);
			responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			result = "Failure";
			responseEntity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	//DELETE PLACE
	@RequestMapping(method=RequestMethod.GET, value="deletePlace/{placeId}")
	public ResponseEntity<String> deletePlace(@PathVariable("placeId") Integer placeId)
	{
		//			Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);

		ResponseEntity<String> responseEntity = null;
		String result;

		try
		{
			result = adminService.deletePlace(placeId);
			responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			responseEntity = new ResponseEntity<>("Failure", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
	
	//ADMIN DASHBOARD NEEDED DETAILS
	@RequestMapping(method=RequestMethod.GET, value="adminViewTraffic")
	public ResponseEntity<AdminDashBoardData> adminViewTraffic()
	{
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<AdminDashBoardData> responseEntity = null;
		AdminDashBoardData data = null;
		
		try 
		{
//			data = adminService.adminViewTraffic();
			responseEntity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			data = new AdminDashBoardData();
			data.setErrorMessage(errorMessage);
			responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	//VIEW USERS COMPONENT
	@RequestMapping(method=RequestMethod.GET, value="getViewUsersComponentData")
	public ResponseEntity<AdminDashBoardData> getViewUsersComponentData(){
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<AdminDashBoardData> responseEntity = null;
		AdminDashBoardData data = null;
		
		try 
		{
			data = adminService.getViewUsersComponentData();
			responseEntity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			data = new AdminDashBoardData();
			data.setErrorMessage(errorMessage);
			responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	ADMIN GET A PARTICULAR USER
	@RequestMapping(method=RequestMethod.GET, value="getUserByEmail/{userEmail}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("userEmail") String userEmail)
	{
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<User> responseEntity = null;
		User user = null;
		
		try 
		{
			user = adminService.getUserByEmail(userEmail + ".com");
			responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			user = new User();
			responseEntity = new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
//	ADMIN MATCHING USERS LIST
	@RequestMapping(method=RequestMethod.GET, value="getUsersListByName/{userName}")
	public ResponseEntity<List<User>> getUsersListByName(@PathVariable("userName") String userName)
	{
		Environment environment= ContextFactory.getContext().getEnvironment();
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<List<User>> responseEntity = null;
		List<User> userList = null;
		
		try 
		{
			userList = adminService.getUsersListByName(userName);
			responseEntity = new ResponseEntity<>(userList, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			userList = new ArrayList<>();
			responseEntity = new ResponseEntity<>(userList, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}

	//VIEW FEEDBACKS
	@RequestMapping(method=RequestMethod.GET, value="getAllFeedbacks")
	public ResponseEntity<List<SiteFeedback>> getAllFeedbacks()
	{
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);
		
		ResponseEntity<List<SiteFeedback>> responseEntity = null;
		List<SiteFeedback> allFeedbacks = null;
		
		try
		{
			allFeedbacks = adminService.getAllFeedbacks();
			responseEntity = new ResponseEntity<>(allFeedbacks, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allFeedbacks = new ArrayList<SiteFeedback>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<>(allFeedbacks, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	//VIEW FEEDBACKS
	@RequestMapping(method=RequestMethod.GET, value="getAllUserQueries")
	public ResponseEntity<List<HelpdeskQuery>> getAllUserQueries()
	{
		adminService = (AdminService) ContextFactory.getContext().getBean(AdminServiceImpl.class);

		ResponseEntity<List<HelpdeskQuery>> responseEntity = null;
		List<HelpdeskQuery> allUserQueries = null;

		try
		{
			allUserQueries = adminService.getAllUserQueries();
			responseEntity = new ResponseEntity<>(allUserQueries, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			allUserQueries = new ArrayList<HelpdeskQuery>();
			System.out.println(exception.getMessage());
			responseEntity = new ResponseEntity<>(allUserQueries, HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}
}

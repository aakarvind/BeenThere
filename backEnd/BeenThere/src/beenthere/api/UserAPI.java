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









import beenthere.model.AdminDashBoardData;
import beenthere.model.Image;
import beenthere.model.ImageInput;
import beenthere.model.LoginCredentials;
import beenthere.model.Messgaes;
import beenthere.model.HelpdeskQuery;
import beenthere.model.SiteFeedback;
import beenthere.model.User;
import beenthere.model.UserHomeData;
import beenthere.model.UserReview;
import beenthere.model.UserSearchResult;
import beenthere.service.AdminService;
import beenthere.service.AdminServiceImpl;
import beenthere.service.GuestService;
import beenthere.service.GuestServiceImpl;
import beenthere.service.UserService;
import beenthere.service.UserServiceImpl;
import beenthere.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="user")
public class UserAPI 
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
	
	private UserService userService;
	
//	ADMIN DASHBOARD NEEDED DETAILS
	@RequestMapping(method=RequestMethod.GET, value="userHomePageData")
	public ResponseEntity<UserHomeData> userHomePageData()
	{
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		
		ResponseEntity<UserHomeData> responseEntity = null;
		UserHomeData data = null;
		
		try 
		{
			data = userService.userHomePageData();
			responseEntity = new ResponseEntity<>(data, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			data = new UserHomeData();
			responseEntity = new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="register")
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		Environment environment = ContextFactory.getContext().getEnvironment();
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class); 
		
		ResponseEntity<User> responseEntity = null;
		User resultUser = null;
		
		try
		{
			resultUser = userService.registerUser(user);
			responseEntity = new ResponseEntity<>(resultUser, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			resultUser = new User();
			resultUser.setName(errorMessage);
			responseEntity = new ResponseEntity<>(resultUser, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="login")
	public ResponseEntity<User> loginUser(@RequestBody LoginCredentials credentials)
	{
		Environment environment = ContextFactory.getContext().getEnvironment();
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class); 
		
		ResponseEntity<User> responseEntity = null;
		User resultUser = null;
		
		try 
		{
			resultUser = userService.loginUser(credentials);
			responseEntity = new ResponseEntity<>(resultUser, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			String errorMessage = environment.getProperty(exception.getMessage());
			resultUser = new User();
			resultUser.setName(errorMessage);
			responseEntity = new ResponseEntity<>(resultUser, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addUserReview")
	public ResponseEntity<UserReview> addUserReview(@RequestBody UserReview userReview)
	{
//		Environment environment = ContextFactory.getContext().getEnvironment();
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class); 
		
		ResponseEntity<UserReview> responseEntity = null;
		UserReview addedUserReview = null;
		
		try
		{
			addedUserReview = userService.addUserReview(userReview);
			responseEntity = new ResponseEntity<>(addedUserReview, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
//			String errorMessage = environment.getProperty(exception.getMessage());
//			admin = new Admin();
//			admin.setName(errorMessage);
			responseEntity = new ResponseEntity<>(userReview, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addSiteFeedback")
	public ResponseEntity<SiteFeedback> addSiteFeedback(@RequestBody SiteFeedback siteFeedback)
	{
//		Environment environment = ContextFactory.getContext().getEnvironment();
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class); 
		
		ResponseEntity<SiteFeedback> responseEntity = null;
		SiteFeedback addedSiteFeedback = null;
		
		try
		{
			addedSiteFeedback = userService.addSiteFeedback(siteFeedback);
			responseEntity = new ResponseEntity<>(addedSiteFeedback, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			addedSiteFeedback = new SiteFeedback();
			responseEntity = new ResponseEntity<>(addedSiteFeedback, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="raiseQuery")
	public ResponseEntity<HelpdeskQuery> raiseQuery(@RequestBody HelpdeskQuery queryModel)
	{
//		Environment environment = ContextFactory.getContext().getEnvironment();
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class); 
		
		ResponseEntity<HelpdeskQuery> responseEntity = null;
		HelpdeskQuery addedQuery = null;
		
		try
		{
			addedQuery = userService.raiseQuery(queryModel);
			responseEntity = new ResponseEntity<>(addedQuery, HttpStatus.OK);
		}
		catch(Exception exception) 
		{
			addedQuery = new HelpdeskQuery();
			responseEntity = new ResponseEntity<>(addedQuery, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="insertImageForReview")
	public ResponseEntity<Image> insertImageForReview(@RequestBody ImageInput imgStr)
	{
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		
		System.out.println("base64 received: " + imgStr.getBase64String());
		
		Image img = new Image(imgStr);
		
		ResponseEntity<Image> responseEntity = null;
		Image insertedImage = null;
        
		try
		{
			insertedImage = userService.insertImageForReview(img);
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
	
	@RequestMapping(method=RequestMethod.GET, value="getSearchResultObjects/{searchStr}")
	public ResponseEntity<UserSearchResult> getSearchResultObjects(@PathVariable("searchStr") String searchStr)
	{
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		
		ResponseEntity<UserSearchResult> responseEntity = null;
		UserSearchResult result = null;
        
		try
		{
			result = userService.getSearchResultObjects(searchStr);
			responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			responseEntity = new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="receive")
	public ResponseEntity<List<Messgaes>> recive(@RequestBody Messgaes logs)
	{
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		Environment environment = ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Messgaes>> responseEntity=null;
	 
	    try{
	    	
	    	List<Messgaes> log=userService.recive(logs);
	    	if(log==null)
	    	{throw new Exception("exception");}
	    	responseEntity = new ResponseEntity<List<Messgaes>>(log,HttpStatus.OK);
	    	
	    }
	    catch(Exception exception) {
			
	    	List<Messgaes> log=new ArrayList<Messgaes>();
	    	responseEntity = new ResponseEntity<List<Messgaes>>(log,HttpStatus.BAD_REQUEST);	
			
			

		}
	    return responseEntity;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="store")
	public ResponseEntity<Messgaes> store(@RequestBody Messgaes logs)
	{
		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		Environment environment = ContextFactory.getContext().getEnvironment();
		ResponseEntity<Messgaes> responseEntity=null;
	 
	    try{
	    	
	    	Messgaes log=userService.store(logs);
	    	if(log==null)
	    	{throw new Exception("exception");}
	    	responseEntity = new ResponseEntity<Messgaes>(log,HttpStatus.OK);
	    	
	    }
	    catch(Exception exception) {
	    	Messgaes log=new Messgaes();
	    	responseEntity = new ResponseEntity<Messgaes>(log,HttpStatus.BAD_REQUEST);
		}
	    return responseEntity;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="usersAll")
	public ResponseEntity<List<User>> getAllUsers(){

		userService = (UserService) ContextFactory.getContext().getBean(UserServiceImpl.class);
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<User>> responseEntity=null;

		List<User> allUsers=new ArrayList<User>();

		try {
			allUsers=userService.getAllUsers();
			responseEntity = new ResponseEntity<>(allUsers,HttpStatus.OK);
		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			User user = new User();		
			allUsers.add(user);			
			responseEntity = new ResponseEntity<>(allUsers,HttpStatus.BAD_REQUEST);
		}

		return responseEntity;

	}
	
}

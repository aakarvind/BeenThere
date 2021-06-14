import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { User } from './model-classes/User';
// import { GuestService } from './guest.service';
import { AdminService } from './admin.service';
import { UserLog } from './model-classes/UserLog';

@Injectable()
export class UserService {
  static isLoggedIn : boolean = false;
  static loggedInUser: User;
  
  constructor(private http:Http) { 
    UserService.isLoggedIn = false;
  }

  registerUser(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/register', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }
  store(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/store',data)
      .toPromise()
      .then(response => {
        console.log('service')
     
        return response.json() as any;
      })
      .catch(this.handleError);
  }


  recive(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/receive',data)
      .toPromise()
      .then(response => {
        console.log('service')
     
        return response.json() as any;
      })
      .catch(this.handleError);
  }
  getAllUsers():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/user/usersAll')
      .toPromise()
      .then(response => {
        console.log('service')
     
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  updateProfile(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/updateProfile', data)
      .toPromise()
      .then(response => {
        AdminService.userToBeDisplayed = response.json();
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  loginUser(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/login', data)
      .toPromise()
      .then(response => {
        UserService.isLoggedIn = true;
        UserService.loggedInUser = response.json();
        console.log('in service ' + UserService.isLoggedIn);
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  addUserReview(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/addUserReview', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  addSiteFeedback(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/addSiteFeedback', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }
  raiseQuery(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/raiseQuery', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  insertImageForReview(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/insertImageForReview', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }
  static userLogDetails: UserLog;
  logInTimeData(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/user/logInTimeData', data)
      .toPromise()
      .then(response => {
        console.log('service')
        UserService.userLogDetails = response.json();
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  logOffTimeData(logOffTime):Promise<any> {
    UserService.userLogDetails.logOffTime = logOffTime;
    console.log('in service sending this')
    console.log(UserService.userLogDetails);
    return this.http.post('http://localhost:8765/BeenThere/user/logOffTimeData', UserService.userLogDetails)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }
  handleError(error){
    return Promise.reject(error.json() || error);
  }
}

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Admin } from './model-classes/Admin';

@Injectable()
export class AdminService {
  viewFeedback(value: any) {
    throw new Error("Method not implemented.");
  }
  static isLoggedIn : boolean = false;
  allCityList;
  allPlaceList;
  static loggedInAdmin: Admin;
  static userToBeDisplayed;

  constructor(private http:Http) { 
    AdminService.isLoggedIn = false;
  }

  adminLogin(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/adminLogin', data)
      .toPromise()
      .then(response => {
        response.json()
        AdminService.isLoggedIn = true;
        AdminService.loggedInAdmin = response.json() as Admin;
      })
      .catch(this.handleError);
  }

  addCity(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/addCity', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  addPlace(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/addPlace', data)
      .toPromise()
      .then(response => {
        return response.json() as any;  
      })
      .catch(this.handleError);
  }

  updateCity(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/updateCity', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  updatePlace(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/updatePlace', data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  deleteCity(data):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/admin/deleteCity/' + data)
      .toPromise()
      .then(response => {
        return response as any;
      })
      .catch(this.handleError);
  }

  deletePlace(data):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/admin/deletePlace/' + data)
      .toPromise()
      .then(response => {
        return response as any;
      })
      .catch(this.handleError);
  }

  adminViewTrafficPageData(): Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/admin/adminDashBoardData')
      .toPromise()
      .then(resp => {
        return resp.json() as any;
      })
      .catch(this.handleError);
  }

  viewPlace(placeId): Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getPlaceWithId/' + placeId)
      .toPromise()
      .then(resp => {
        return resp.json() as any;
      })
      .catch(this.handleError);
  }

  
  getViewUsersComponentData():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/admin/getViewUsersComponentData')
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getUserByEmail(userName: string):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/admin/getUserByEmail/' + userName)
      .toPromise()
      .then(response => {
        console.log(response.json());
        AdminService.userToBeDisplayed = response.json();
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  insertImageForCity(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/insertImageForCity', data)
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }


  insertImageForPlace(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/admin/insertImageForPlace', data)
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }

  getAllCityNamesList():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getAllCityNamesList')
      .toPromise()
      .then(response => {
        return response.json() as string[];
        // console.log('service   ' + this.allCityList);
      })
      .catch(this.handleError);
  }

  getAllPlaceNamesInCity(cityId):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getAllPlaceNamesInCity/' + cityId)
      .toPromise()
      .then(response => {
        return response.json() as string[];
      })
      .catch(this.handleError);
  }

  getAllFeedbacks(){
    return this.http.get('http://localhost:8765/BeenThere/admin/getAllFeedbacks')
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getAllUserQueries(){
    return this.http.get('http://localhost:8765/BeenThere/admin/getAllUserQueries')
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
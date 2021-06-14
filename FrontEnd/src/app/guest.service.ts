import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { SearchResultObjects } from './model-classes/SearchResultObjects';

@Injectable()
export class GuestService {
  isloggedin : boolean;

  static multipleToBeDisplayed: SearchResultObjects;
  static cityToBeDisplayed;
  static placeToBeDisplayed;
  static trendingPlaces;
  static reviewAbtPlace = '';
  static reviewAbtPlaceCity = '';

  constructor(private http:Http) {
    this.isloggedin = false;
   }

  userHomePageData():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/user/userHomePageData')
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getAllCities():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getAllCities')
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }

  getAllPlaces():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getAllPlaces')
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }

  getPlacesInCity(data):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getPlacesInCity/' + data)
      .toPromise()
      .then(response => {
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getCityById(cityId: number):Promise<any> {
    GuestService.placeToBeDisplayed = null;
    GuestService.multipleToBeDisplayed = null;

    return this.http.get('http://localhost:8765/BeenThere/guest/getCityWithId/' + cityId)
      .toPromise()
      .then(response => {
        GuestService.cityToBeDisplayed = response.json();
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getPlaceById(placeId: number):Promise<any> {
    GuestService.cityToBeDisplayed = null;
    GuestService.multipleToBeDisplayed = null;

    return this.http.get('http://localhost:8765/BeenThere/guest/getPlaceWithId/' + placeId)
      .toPromise()
      .then(response => {
        GuestService.placeToBeDisplayed = response.json();
        GuestService.reviewAbtPlaceCity = GuestService.placeToBeDisplayed.cityId;
        GuestService.reviewAbtPlace = GuestService.placeToBeDisplayed.placeId;
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  getReviewsAboutPlace(data):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getReviewsAboutPlace/' + data)
      .toPromise()
      .then(response => {
        console.log(response.json())
        return response.json() as any;
      })
      .catch(this.handleError);
  }

  insertImage(data):Promise<any> {
    return this.http.post('http://localhost:8765/BeenThere/guest/insertImage', data)
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }

  getImageById(data):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getImageById/' + data)
      .toPromise()
      .then(response => {
        response.json();
      })
      .catch(this.handleError);
  }

  getAllCitiesAndPlacesList():Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/guest/getAllCitiesAndPlacesList')
      .toPromise()
      .then(response => {
        return response.json() as string[];
      })
      .catch(this.handleError);
  }

  handleError(error){
    return Promise.reject(error.json() || error);
  }

  fetchSearchResult(searchStr: string):Promise<any> {
    return this.http.get('http://localhost:8765/BeenThere/user/getSearchResultObjects/' + searchStr)
      .toPromise()
      .then(response => {
        GuestService.multipleToBeDisplayed = response.json();
        return response.json() as SearchResultObjects;
      })
      .catch(this.handleError);
  }

}

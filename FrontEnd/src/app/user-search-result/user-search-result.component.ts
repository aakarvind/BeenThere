import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { GuestService } from '../guest.service';
import { SearchResultObjects } from '../model-classes/SearchResultObjects';

@Component({
  selector: 'app-user-search-result',
  templateUrl: './user-search-result.component.html',
  styleUrls: ['./user-search-result.component.css']
})
export class UserSearchResultComponent implements OnInit {
  ePic = "http://www.lifeawayfromlife.com/wordpress/wp-content/uploads/ladakhbiketour.jpg";

  dPic = "https://images.thrillophilia.com/image/upload/s--yIJsXrGC--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/118/990/original/1528458359_shutterstock_644222968.jpg.jpg?1528458359";
 
  cPic = "https://www.pictureofrajasthan.com/wp-content/uploads/destination/slide3.jpg";
 
  bPic = "https://images.thrillophilia.com/image/upload/s--t483tMo6--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/115/212/original/1502349513_kodaikanal-india-hills-hd-wallpaper.jpg.jpg?1502349513";
 
  aPic = "https://www.tajmahal.gov.in/images/slider/slider.jpg"; 
  
  toBeDisplayed: SearchResultObjects;
  dataFetched: boolean = false;
  trendingPlaces;

  constructor(private router: Router, private userService: UserService, private guestService: GuestService) { 
    this.toBeDisplayed = GuestService.multipleToBeDisplayed;
    this.trendingPlaces = GuestService.trendingPlaces;

    console.log('result comp');
    console.log(this.toBeDisplayed);
  }

  ngOnInit() {
    if(this.toBeDisplayed == null){
      this.router.navigate(['/']);
    }
  }

  loadCityWithId(cityId: number){
    this.guestService.getCityById(cityId)
    .then(resp => {
      this.router.navigate(['/userviewcity']);
    })
    .catch(err => {
      console.log(err);
    })
  }

  loadPlaceWithId(placeId: number){
    this.guestService.getPlaceById(placeId)
    .then(resp => {
      this.router.navigate(['/userviewplace']);
    })
    .catch(err => {
      console.log(err);
    })
  }
}

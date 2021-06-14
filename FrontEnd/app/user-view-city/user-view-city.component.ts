import { Component, OnInit } from '@angular/core';
import { GuestService } from '../guest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-view-city',
  templateUrl: './user-view-city.component.html',
  styleUrls: ['./user-view-city.component.css']
})
export class UserViewCityComponent implements OnInit {

  ePic = "https://images.wallpaperscraft.com/image/mountain_lake_valley_110622_1280x720.jpg";
  sPic="https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2018/08/karsog-himachal.jpg";

  dPic = "http://blogs.himalyantrips.com/wp-content/uploads/2018/10/kullu.jpg";
 
  cPic = "https://images.wallpaperscraft.com/image/snow_mountains_road_turn_118276_1280x720.jpg";
 
  bPic = "https://images.thrillophilia.com/image/upload/s--kupQb-PU--/c_fill,f_auto,fl_strip_profile,h_600,q_auto,w_975/v1/images/photos/000/127/614/original/1524745600_Parvati_Valley_river_kasol.jpg.jpg?1524745598";
 
  aPic = "https://images.wallpaperscraft.com/image/mountains_snow_night_136396_1280x720.jpg";  

  constructor(private guestService: GuestService, private router: Router) { 
    if(GuestService.cityToBeDisplayed == null){
      this.router.navigate(['/']);
    }
  }

  cityToBeDisplayed;
  placesList;

  ngOnInit() {
    this.cityToBeDisplayed = GuestService.cityToBeDisplayed;
    this.getPlacesInCity();
  }

  getPlacesInCity(){
    this.guestService.getPlacesInCity(this.cityToBeDisplayed.cityId)
    .then(resp => {
      this.placesList = resp;
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

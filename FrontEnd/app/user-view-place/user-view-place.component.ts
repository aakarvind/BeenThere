import { Component, OnInit } from '@angular/core';
import { GuestService } from '../guest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-view-place',
  templateUrl: './user-view-place.component.html',
  styleUrls: ['./user-view-place.component.css']
})
export class UserViewPlaceComponent implements OnInit {
  ePic = "https://images.wallpaperscraft.com/image/mountain_lake_valley_110622_1280x720.jpg";
  sPic = "https://images.wallpaperscraft.com/image/beach_sea_ice_floe_sand_53119_1280x720.jpg";
  dPic = "https://images.thrillophilia.com/image/upload/s--yIJsXrGC--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/118/990/original/1528458359_shutterstock_644222968.jpg.jpg?1528458359";
  cPic = "https://www.pictureofrajasthan.com/wp-content/uploads/destination/slide3.jpg";
  bPic = "https://images.thrillophilia.com/image/upload/s--t483tMo6--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/115/212/original/1502349513_kodaikanal-india-hills-hd-wallpaper.jpg.jpg?1502349513";
  aPic = "https://www.tajmahal.gov.in/images/slider/slider.jpg"; 

  placeToBeDisplayed;
  reviewsList;
  placeDescParts = [];

  constructor(private router: Router, private guestService: GuestService) { 
    this.placeToBeDisplayed = GuestService.placeToBeDisplayed;

    let i=0;
    while(i < this.placeToBeDisplayed.description.length){
      this.placeDescParts.push(this.placeToBeDisplayed.description.substr(i, 150))
      i = i+150;
    }
  }

  ngOnInit() {
    if(this.placeToBeDisplayed == null){
      this.router.navigate(['/']);
    }

    this.getReviewsAboutPlace();
  }

  getReviewsAboutPlace(){
    console.log(this.placeToBeDisplayed.placeId)
    this.guestService.getReviewsAboutPlace(this.placeToBeDisplayed.placeId)
    .then(resp => {
      this.reviewsList = resp;
      console.log(resp);
    })
    .catch(err => {
      console.log(err);
    })
  }

  submitReviewAboutPlace(){
    this.router.navigate(['/userreview']);
  }

}

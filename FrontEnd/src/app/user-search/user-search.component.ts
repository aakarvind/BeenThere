import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { GuestService } from '../guest.service';
import { HomePageData } from '../model-classes/HomePageData';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent implements OnInit {
  
  ePic = "https://images.wallpaperscraft.com/image/mountain_lake_valley_110622_1280x720.jpg";
  sPic = "https://images.wallpaperscraft.com/image/beach_sea_ice_floe_sand_53119_1280x720.jpg";
  dPic = "https://images.thrillophilia.com/image/upload/s--yIJsXrGC--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/118/990/original/1528458359_shutterstock_644222968.jpg.jpg?1528458359";
  cPic = "https://www.pictureofrajasthan.com/wp-content/uploads/destination/slide3.jpg";
  bPic = "https://images.thrillophilia.com/image/upload/s--t483tMo6--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/115/212/original/1502349513_kodaikanal-india-hills-hd-wallpaper.jpg.jpg?1502349513";
  aPic = "https://www.tajmahal.gov.in/images/slider/slider.jpg"; 

  fetchedResult : boolean = false;
  noResultFound: boolean = false;
  listOfMatchedResults = [];

  listOfItems = [];
  homePageData: HomePageData;
  constructor(private router:Router, private userService: UserService, private guestService: GuestService) { 
    
    this.guestService.userHomePageData()
    .then(resp => {
      this.homePageData = resp;
    })
    .catch(err => {
      console.log(err);
    })
    
    
    
    
    this.guestService.getAllCitiesAndPlacesList()
    .then(resp => {
      this.listOfItems = resp;
    })
    .catch(err => {
      console.log(err);
    })
  }

  ngOnInit() {
    if(UserService.loggedInUser == null){
      this.router.navigate(['/']);
    }
  }

  textChanged(event: string){
    this.fetchedResult = false;
    this.noResultFound = false;
    this.listOfMatchedResults = [];
    console.log(event + " " + this.fetchedResult);
   
    if(event !== "") 
    {
      for(let i of this.listOfItems)
      {
        if(i.toLowerCase().indexOf(event.toLowerCase()) != -1) 
        {
          this.listOfMatchedResults.push(i);
          if(this.listOfMatchedResults.length == 3){
            break;
          }
        }
      }

      this.fetchedResult = true;
      console.log(this.listOfMatchedResults);
      console.log(this.fetchedResult);
    } 

    if(this.listOfMatchedResults.length == 0 ) {
      this.noResultFound = true;
    }
  }
   
  searchResultSelected(a) {
    this.fetchedResult = false;
   
    // console.log(a);
   
    // Selected option is set as text in search bar 
    (<HTMLInputElement>document.getElementById("searchInputField")).value = a;
   
    // console.log((<HTMLInputElement>document.getElementById("searchInputField")).value)
  }

  loadSearchResults() {
    let keyStr = (<HTMLInputElement>document.getElementById("searchInputField")).value;

    this.guestService.fetchSearchResult(keyStr)
    .then(resp => {
      console.log(resp);
      this.router.navigate(['/userSearchResult']);
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

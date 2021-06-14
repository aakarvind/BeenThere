import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lootgaya',
  templateUrl: './lootgaya.component.html',
  styleUrls: ['./lootgaya.component.css']
})
export class LootgayaComponent implements OnInit {
  
  ePic = "http://www.lifeawayfromlife.com/wordpress/wp-content/uploads/ladakhbiketour.jpg";

  dPic = "https://images.thrillophilia.com/image/upload/s--yIJsXrGC--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/118/990/original/1528458359_shutterstock_644222968.jpg.jpg?1528458359";
 
  cPic = "https://www.pictureofrajasthan.com/wp-content/uploads/destination/slide3.jpg";
 
  bPic = "https://images.thrillophilia.com/image/upload/s--t483tMo6--/c_fill,f_auto,fl_strip_profile,h_775,q_auto,w_1600/v1/images/photos/000/115/212/original/1502349513_kodaikanal-india-hills-hd-wallpaper.jpg.jpg?1502349513";
 
  aPic = "https://www.tajmahal.gov.in/images/slider/slider.jpg"; 
  fetchedResult : boolean = false;
  replyToQuery = false;
  star_rating=1;
 listOfMatchedResults = [];

 listOfItems = [ 'Afghanistan', 'Albania', 'Algeria', 'Andorra', 'Angola', 'Antigua and Barbuda', 'Argentina', 'Armenia', 'Aruba', 'Australia', 'Austria', 'Azerbaijan'];
  constructor(private router: Router) { 
    
  }

  ngOnInit() {
  }

  action(){
    console.log('reply clicked');
    this.replyToQuery = true;
  }
  textChanged(event: string){
    this.fetchedResult = false;
    this.listOfMatchedResults = [];
    console.log(event + " " + this.fetchedResult);
   
    if(event !== "") 
    {
      for(let i of this.listOfItems)
      {
        if(i.toLowerCase().indexOf(event) != -1) 
        {
          this.listOfMatchedResults.push(i);
        }
      }

      this.fetchedResult = true;
      console.log(this.listOfMatchedResults);
      console.log(this.fetchedResult);
    } 

    // if(this.listOfMatchedResults.length == 0 ) {
    //   this.fetchedResult = false;
    // }
  }
   
  searchResultSelected(a) {
    this.fetchedResult = false;
   
    // console.log(a);
   
    // Selected option is set as text in search bar 
    (<HTMLInputElement>document.getElementById("searchInputField")).value = a;
   
    // console.log((<HTMLInputElement>document.getElementById("searchInputField")).value)
  }
}

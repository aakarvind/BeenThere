import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-dash-board',
  templateUrl: './admin-dash-board.component.html',
  styleUrls: ['./admin-dash-board.component.css']
})
export class AdminDashBoardComponent implements OnInit {
  Admin = 'Aseem Garg';
  bar1=24;
  bar2= 60;
  submitr = false;
  trendingPlaces: any[];
  mostSearchedPlaces;
  mostContactedUsers;
  constructor(private router: Router,private adminService: AdminService) { }

  ngOnInit() {
    this.bar1Color();
    this.bar2Color();
    this.adminService.adminViewTrafficPageData()
    .then(resp => {
      this.trendingPlaces = resp.trendingPlace;
      this.mostSearchedPlaces = resp.topSearchedPlaces;
      this.mostContactedUsers=resp.topContactedUsers;
    })
    .catch(err => {
      console.log('error occurred');
    });
  }
  action(){
    console.log('reply clicked');
    this.submitr = true;
  }

  bar1Color(){
    let col;
    let percentColor;
    if(this.bar1<25){
      col = "color1";
      percentColor = "red";
    }
    else if(this.bar1 < 50){
      col = "color2";
      percentColor = "rgb(255, 153, 0)";
    }
    else if(this.bar1<75){
      col = "color3";
      percentColor = "rgb(50, 205, 205)";
    }
    else{
      col = "color4";
      percentColor = "yellowgreen";
    }
    document.getElementById("bar1a").classList.add(col);
    document.getElementById("bar1b").classList.add(col);
    document.getElementById("bar1Percentage").style.color = percentColor;
  }

  bar2Color(){
    let col;
    let percentColor;
    if(this.bar2<25){
      col = "color1";
      percentColor = "red";
    }
    else if(this.bar2 < 50){
      col = "color2";
      percentColor = "rgb(255, 153, 0)";
    }
    else if(this.bar2<75){
      col = "color3";
      percentColor = "rgb(50, 205, 205)";
    }
    else{
      col = "color4";
      percentColor = "yellowgreen";
    }
    document.getElementById("bar2a").classList.add(col);
    document.getElementById("bar2b").classList.add(col);
    document.getElementById("bar2Percentage").style.color = percentColor;
  }

}

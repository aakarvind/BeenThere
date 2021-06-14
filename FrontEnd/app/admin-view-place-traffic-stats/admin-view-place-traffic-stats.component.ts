import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Place } from '../model-classes/Place';

@Component({
  selector: 'app-admin-view-place-traffic-stats',
  templateUrl: './admin-view-place-traffic-stats.component.html',
  styleUrls: ['./admin-view-place-traffic-stats.component.css']
})
export class AdminViewPlaceTrafficStatsComponent implements OnInit {
  widt = 16;
  submitr = false;
  submitreview = false;
  trendingPlaces: [Place];
  mostSearchedPlaces: [Place];
  viewPlaceForm: FormGroup;
  cityNamesList:any;
  placeNamesList:any;
  showOptions = false;
  placeToBeViewed: Place;

  constructor(private fb: FormBuilder, private adminService: AdminService, private router: Router) {

    adminService.getAllCityNamesList()
    .then(response => {
      this.cityNamesList = response;
    })
    .catch(error => {
      console.log('some error');
    });

    this.showOptions = true;
    
    this.viewPlaceForm=this.fb.group({
      cityId: ['', Validators.required],
      placeId: ['', Validators.required]
    });
  }

 

  ngOnInit() {
    this.adminService.adminViewTrafficPageData()
    .then(resp => {
      this.trendingPlaces = resp.trendingPlace;
      this.mostSearchedPlaces = resp.topSearchedPlaces;
    })
    .catch(err => {
      console.log('error occurred');
    });
  }

  viewPlace(){
    console.log(this.viewPlaceForm.controls.placeId.value);
    this.adminService.viewPlace(this.viewPlaceForm.controls.placeId.value)
    .then(resp => {
      this.placeToBeViewed = resp;
      console.log(this.placeToBeViewed);
      this.submitr = true;
      this.submitreview = true;
    })
    .catch(err => {
      console.log();
    })
  }



  getAllPlaceNamesInCity(){
    console.log(this.viewPlaceForm.controls.cityId.value);
    this.adminService.getAllPlaceNamesInCity(this.viewPlaceForm.controls.cityId.value)
    .then(resp => {
      this.placeNamesList = resp;
      console.log(resp);
    })
    .catch(err => {
      console.log();
    })
  }
}

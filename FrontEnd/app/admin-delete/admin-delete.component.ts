import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router,NavigationEnd  } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-delete',
  templateUrl: './admin-delete.component.html',
  styleUrls: ['./admin-delete.component.css']
})
export class AdminDeleteComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  placeDeleteForm: FormGroup;
  cityDeleteForm: FormGroup;
  cityNamesList:any;
  placeNamesList:any;
  showOptions = false;

  constructor(private fb: FormBuilder, private adminService:AdminService,private router:Router) { 

    adminService.getAllCityNamesList()
    .then(response => {
      this.cityNamesList = response;
    })
    .catch(error => {
      console.log('some error');
    });

    this.showOptions = true;
    this.router.routeReuseStrategy.shouldReuseRoute = function(){
      return false;
    }

    this.router.events.subscribe((evt) => {
      if(evt instanceof NavigationEnd) {
        this.router.navigated = false;
        window.scrollTo(0, 0);
      }
    });
  }

  ngOnInit() {
  }

  radioVal = null;
  radioUpdate(radioVal) {
    this.radioVal = radioVal;
    console.log(radioVal);
    if(radioVal == 'place'){
      this.placeDeleteForm=this.fb.group({
        cityId: ['', Validators.required],
        placeId: ['', Validators.required]
      });
    }
    if(radioVal == 'city'){
      this.cityDeleteForm = this.fb.group({
        cityId: ['', Validators.required]
      });
    }
  }

  deleteCity(){
    this.successMessage = null;
    this.errorMessage = null;

    this.adminService.deleteCity(this.cityDeleteForm.controls.cityId.value)
    .then(response => {
      console.log(response);
      this.successPopUp('City Deleted Successfully');
      this.router.navigate(['/adminDelete']);
    })
    .catch(error => {
      this.errorMessage = error.name;
    })  
  }

  deletePlace(){
    this.successMessage = null;
    this.errorMessage = null;

    this.adminService.deletePlace(this.placeDeleteForm.controls.placeId.value)
    .then(response => {
      console.log(response);
      this.successPopUp('Place Deleted Successfully');
      this.router.navigate(['/adminDelete']);
    })
    .catch(error => {
      this.errorMessage = error.name;
    })  
  }

  

  getAllPlaceNamesInCity(){
    console.log(this.placeDeleteForm.controls.cityId.value);
    this.adminService.getAllPlaceNamesInCity(this.placeDeleteForm.controls.cityId.value)
    .then(resp => {
      this.placeNamesList = resp;
      console.log(resp);
    })
    .catch(err => {
      console.log();
    })
  }

  successPopUp(successMsg){
    let Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 2000
    });
    
    Toast.fire({
      type: 'success',
      title: successMsg
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router, NavigationEnd } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-update',
  templateUrl: './admin-update.component.html',
  styleUrls: ['./admin-update.component.css']
})
export class AdminUpdateComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  placeUpdateForm: FormGroup;
  cityUpdateForm: FormGroup;
  cityNamesList:any;
  placeNamesList:any;
  showOptions = false;


  constructor(private fb: FormBuilder, private adminService:AdminService, private router: Router) {
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
      this.placeUpdateForm=this.fb.group({
        name:['', Validators.required] ,
        cityId: ['', Validators.required],
        placeId: ['', Validators.required],
        description:['', Validators.required]
      });
    }
    if(radioVal == 'city'){
      this.cityUpdateForm = this.fb.group({
        name: ['', Validators.required] ,
        cityId: ['', Validators.required],
        description:['', Validators.required]
      });
    }
  }

  updateCity(){
    this.successMessage = null;
    this.errorMessage = null;
    // console.log(this.cityUpdateForm.value);

    this.adminService.updateCity(this.cityUpdateForm.value)
    .then(response => {
      this.successMessage=response.name;
      this.successPopUp('City Updated Successfully');
      this.router.navigate(['/adminUpdate']);
    })
    .catch(error => {
      this.errorMessage = error.name;
    })  
  }

  updatePlace(){
    // console.log('update place -- ts')
    // console.log(this.placeUpdateForm.value)
    this.successMessage = null;
    this.errorMessage = null;
    console.log(this.placeUpdateForm.value);

    this.adminService.updatePlace(this.placeUpdateForm.value)
    .then(response => {
      this.successMessage=response.name;
      this.successPopUp('Place updated Successfully');
      this.router.navigate(['/adminUpdate']);
    })
    .catch(error => {
      this.errorMessage = error.name;
    })  
  }

  getAllPlaceNamesInCity(){
    console.log(this.placeUpdateForm.controls.cityId.value);
    this.adminService.getAllPlaceNamesInCity(this.placeUpdateForm.controls.cityId.value)
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

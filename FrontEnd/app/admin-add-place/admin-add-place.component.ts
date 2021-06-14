import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-add-place',
  templateUrl: './admin-add-place.component.html',
  styleUrls: ['./admin-add-place.component.css']
})
export class AdminAddPlaceComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  addPlaceForm: FormGroup;
  cityNamesList:any;
  showOptions = false;

  constructor(private fb: FormBuilder, private adminService:AdminService, private router: Router) {
    adminService.getAllCityNamesList()
    .then(response => {
      this.cityNamesList = response;
    })
    .catch(error => {
      console.log('some error');
    }
    )

    this.showOptions = true;
  }

  ngOnInit() {
    this.addPlaceForm = this.fb.group({
      name: ['', Validators.required] ,
      cityId: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  addPlaces(){
    this.successMessage = null;
    this.errorMessage = null;
    console.log(this.addPlaceForm.value);
    this.adminService.addPlace(this.addPlaceForm.value)
    .then(response => {
      this.successMessage=response.name;
      this.successPopUp();
      this.router.navigate(['/adminHome']); 
    })
    .catch(error => {
      this.errorMessage = error.name;
    })  
  }
  successPopUp(){
    let Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 2000
    });
    
    Toast.fire({
      type: 'success',
      title: 'Place Added Successfully'
    })
  }
}

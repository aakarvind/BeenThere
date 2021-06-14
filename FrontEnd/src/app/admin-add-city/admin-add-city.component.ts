import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-admin-add-city',
  templateUrl: './admin-add-city.component.html',
  styleUrls: ['./admin-add-city.component.css']
})
export class AdminAddCityComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  addCityForm: FormGroup;
  constructor(private fb: FormBuilder, private addcity:AdminService,private router:Router) { 

  }

  ngOnInit() {
    this.addCityForm = this.fb.group({
      name: ['', Validators.required],
      description:['',Validators.required]
  });
}
  AddCity(){
    this.successMessage = null;
    this.errorMessage = null;
    console.log(JSON.stringify(this.addCityForm.value));
    this.addcity.addCity(this.addCityForm.value)
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
      title: 'City added successfully'
    })
  }
}

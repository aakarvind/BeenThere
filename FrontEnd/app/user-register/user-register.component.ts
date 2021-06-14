import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  signUpForm: FormGroup;

  constructor(private fb: FormBuilder,private userService:UserService,private router:Router) {
    
  }

  ngOnInit() {
    this.signUpForm = this.fb.group({
      name: ['',[ Validators.required,Validators.pattern("[A-Za-z ]+")]],
      email: ['',[ Validators.required,Validators.pattern("[A-Za-z0-9_!#$%^&*+-]+@(gmail|yahoo)['.']com")]],
      contactNumber: ['',[ Validators.required,Validators.maxLength(10),Validators.minLength(10)]],
      password: ['', [Validators.required,Validators.minLength(8),Validators.pattern("[A-Za-z0-9_!@#$%^&*+-]+")]],
      country: ['', [Validators.required]],
      dpStr: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      dob: ['', [Validators.required]]
    });
  }

  register() {
    this.successMessage = null;
    this.errorMessage = null;
    console.log(JSON.stringify(this.signUpForm.value));
    this.userService.registerUser(this.signUpForm.value)
      .then(response => {
        console.log(response)
        this.successPopUp();
        this.router.navigate(['/userLogin']);
        this.successMessage = response.name;
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
      title: 'Registration Successful'
    })
  }

}

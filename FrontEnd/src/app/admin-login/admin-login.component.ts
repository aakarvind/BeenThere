import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  adminLoginForm: FormGroup;
  isLoggedIn : boolean = false;
  constructor(private fb: FormBuilder, private admin: AdminService, private router: Router) { }

  ngOnInit() {
    this.adminLoginForm = this.fb.group({
      loginId: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  Adminlogin() {
    this.successMessage = null; 
    this.errorMessage = null;
    console.log(JSON.stringify(this.adminLoginForm.value));
    this.admin.adminLogin(this.adminLoginForm.value)
    .then(response => {
      this.isLoggedIn = AdminService.isLoggedIn;
      this.router.navigate(['/adminHome']);
      //  console.log('in component' + this.isLoggedIn)
      })
      .catch(error => {
        this.errorMessage = error.name;
        this.isLoggedIn = AdminService.isLoggedIn;
      })
      // console.log('in component(ser)' + this.admin.isLoggedIn)
  }

}

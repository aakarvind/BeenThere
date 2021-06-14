import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { UserLog } from '../model-classes/UserLog';
import { User } from '../model-classes/User';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  userLoginForm: FormGroup;
  errorMessage: string;
  successMessage: string;
  isLoggedIn : boolean = false;
  public static userId:String;
  public static neededlogsvals: UserLog = new UserLog;
  public static tempstore:String;
  public static usrs:User=new User;
  logvaluesneeded: UserLog = new UserLog;
  constructor(private fb: FormBuilder,private userservice: UserService, private router:Router) { }

  ngOnInit() {
    this.userLoginForm = this.fb.group({
      loginId: ['',[ Validators.required,Validators.pattern("[A-Za-z0-9_!#$%^&*+-]+@(gmail|yahoo)['.']com")]],
      password: ['', Validators.required]
    });
  }
  Userlogin() {
    this.successMessage = null;
    this.errorMessage = null;

    console.log(JSON.stringify(this.userLoginForm.value));
    this.userservice.loginUser(this.userLoginForm.value)
      .then(response => {
        UserLoginComponent.usrs=response;
        UserLoginComponent.userId=response.email;
       
        let nc: Date = new Date();
        this.logvaluesneeded.logInTime = nc;
        this.logvaluesneeded.userEmailID = this.userLoginForm.controls.loginId.value;
        this.userservice.logInTimeData(this.logvaluesneeded)
          .then(resp => {
            console.log("works");
            console.log(resp);
            UserLoginComponent.neededlogsvals = resp;
            
        console.log("UserLoginComponent.neededlogsvals.userLogId");
        console.log(UserLoginComponent.neededlogsvals.userLogId);
          }).catch(error => {
            this.errorMessage = error.name;
            console.log("error");
          })

     
        this.isLoggedIn = UserService.isLoggedIn;
        this.router.navigate(['/userHome']);
        // console.log('in component' + this.isLoggedIn)
      })
      .catch(error => {
        this.errorMessage = error.name;
        this.isLoggedIn = UserService.isLoggedIn;
      })



    // console.log('in component(ser)' + this.ppp.isLoggedIn)

  }

}

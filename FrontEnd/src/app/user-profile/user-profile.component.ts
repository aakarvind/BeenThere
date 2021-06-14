import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  profileForm:FormGroup;
  userToBeDisplayed;
  constructor(private userService: UserService, private router: Router,private fb:FormBuilder) { 
    this.userToBeDisplayed = UserService.loggedInUser;
    
    if(UserService.loggedInUser == null){
      this.router.navigate(['/']);
    }

    
  }

  ngOnInit() {
    if(this.userToBeDisplayed.dpStr == null){
      if(this.userToBeDisplayed.gender == 'FEMALE'){
        console.log('female')
        this.userToBeDisplayed.dpStr = 'https://www.w3schools.com/howto/img_avatar2.png';
        UserService.loggedInUser.dpStr = 'https://www.w3schools.com/howto/img_avatar2.png';
      }
      else{
        console.log('else')
        this.userToBeDisplayed.dpStr = 'https://www.w3schools.com/howto/img_avatar.png';
        UserService.loggedInUser.dpStr = 'https://www.w3schools.com/howto/img_avatar.png';
      }
    }



    this.profileForm = this.fb.group({
      name: [UserService.loggedInUser.name,[ Validators.required]],
      email: [UserService.loggedInUser.email,[ Validators.required]],
      contactNumber: [ UserService.loggedInUser.contactNumber, [Validators.required]],
      password: [ UserService.loggedInUser.password, [Validators.required]],
      country: [UserService.loggedInUser.country, [Validators.required]],
      dpStr: [this.userToBeDisplayed.dpStr, [Validators.required]],
      gender: [UserService.loggedInUser.gender, [Validators.required]],
      dob: [UserService.loggedInUser.dob, [Validators.required]]
    });
  }

  updateUserProfile() {
    this.userService.updateProfile(this.profileForm.value)
    .then(resp => {
      Swal.fire(
        'Profile Updated!',
        'success'
      )
    })
    .catch(err => {
      console.log(err);
    })
  }

}

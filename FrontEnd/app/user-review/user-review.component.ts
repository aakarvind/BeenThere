import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { Place } from '../model-classes/Place';
import { UserService } from '../user.service';
import { ImageInput } from '../model-classes/ImageInput';
import { GuestService } from '../guest.service';

@Component({
  selector: 'app-user-review',
  templateUrl: './user-review.component.html',
  styleUrls: ['./user-review.component.css']
})
export class UserReviewComponent implements OnInit {
  cityNamesList:any;
  showOptions = false;
  userReviewForm: FormGroup;
  userReviewPicForm: FormGroup;
  placeNamesList:any;
  userViewed:Place;
  submitr = false;
  submitreview = false;
  imageInserted = false;
  imgUrl;
  selectDisabled = false;
  
  constructor(private fb: FormBuilder, private adminService:AdminService, private userService: UserService, private router: Router) {
    adminService.getAllCityNamesList()
    .then(response => {
      this.cityNamesList = response;
    })
    .catch(error => {
      console.log('some error');
    }
    )

    this.showOptions = true;

    if(GuestService.reviewAbtPlace != null){
      this.selectDisabled = true;
      this.adminService.getAllPlaceNamesInCity(GuestService.reviewAbtPlaceCity)
    .then(resp => {
      this.placeNamesList = resp;
      console.log(resp);
    })
    .catch(err => {
      console.log(err);
    })
    }
  }


  getAllPlaceNamesInCity(){
    console.log(this.userReviewForm.controls.cityId.value);
    this.adminService.getAllPlaceNamesInCity(this.userReviewForm.controls.cityId.value)
    .then(resp => {
      this.placeNamesList = resp;
      console.log(resp);
    })
    .catch(err => {
      console.log(err);
    })

    UserService.loggedInUser;
  }

  ngOnInit() {
    this.userReviewForm = this.fb.group({
      name: [UserService.loggedInUser.name,[ Validators.required,Validators.pattern("[A-Za-z ]+")]],
      userEmail: [UserService.loggedInUser.email,[ Validators.required,Validators.pattern("[A-Za-z0-9_!#$%^&*+-]+@(gmail|yahoo)['.']com")]],
      phone: [UserService.loggedInUser.contactNumber,[ Validators.required,Validators.maxLength(10),Validators.minLength(10)]],
      cityId: [GuestService.reviewAbtPlaceCity, [Validators.required]],
      placeId: [GuestService.reviewAbtPlace, [Validators.required]],
      review: ['', [Validators.required]],
      rating:[0,[Validators.required]],
      privacyPreference:['',[Validators.required]],
      timeStamp: [Date.now()]
    });
    this.userReviewPicForm = this.fb.group({
      reviewId: ['', [Validators.required]],
      base64String: ['', []]
    });

    console.log(this.userReviewForm.value)
  }

  reviewForm(){
    console.log('form submitted');
    console.log(this.userReviewForm.value);


    this.userService.addUserReview(this.userReviewForm.value)
    .then(resp => {
      console.log('added review to backend');
      console.log(this.imageInserted);
      if(this.imageInserted){
        let imgIp: ImageInput = new ImageInput;
        imgIp.base64String = this.imgUrl;
        imgIp.reviewId = resp.reviewId;
        this.insertImageForReview(imgIp);
      }
      console.log(resp);
    })
    .catch(err => {
      console.log(err);
    })
  }

  insertImageForReview(data){
    console.log(data);
    this.userService.insertImageForReview(data)
    .then(resp => {
      //sweetalert
      this.router.navigate(['/userHome']);
    })
  }

  getBase64(event) {
    console.log(event);
    let me = this;
    let file = event.target.files[0];
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
      me.imageInserted = true;
      me.imgUrl = reader.result;
      console.log(me.imgUrl);
    };
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }

}


import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-view-user-profile',
  templateUrl: './admin-view-user-profile.component.html',
  styleUrls: ['./admin-view-user-profile.component.css']
})
export class AdminViewUserProfileComponent implements OnInit {

  userToBeDisplayed;

  constructor() { 
    this.userToBeDisplayed = AdminService.userToBeDisplayed;
  }

  ngOnInit() {
    this.userToBeDisplayed = AdminService.userToBeDisplayed;
  }


}

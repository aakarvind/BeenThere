import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-feedback',
  templateUrl: './admin-feedback.component.html',
  styleUrls: ['./admin-feedback.component.css']
})
export class AdminFeedbackComponent implements OnInit {

  allFeedbacks;
  displayFeedback: boolean = false;

  constructor(private adminService: AdminService) { 
    this.adminService.getAllFeedbacks()
    .then(resp => {
      this.allFeedbacks = resp;
      this.displayFeedback = true;
    })
    .catch(err => {
      console.log(err);
    })
  }

  ngOnInit() {
    
  }

}

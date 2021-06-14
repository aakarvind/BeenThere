import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-feedback',
  templateUrl: './user-feedback.component.html',
  styleUrls: ['./user-feedback.component.css']
})
export class UserFeedbackComponent implements OnInit {
feedbackForm:FormGroup;
  constructor(private router:Router,private user:UserService,private fb:FormBuilder) { 

    
  }

  ngOnInit() {
    this.feedbackForm = this.fb.group({
      userName: [UserService.loggedInUser.name,[ Validators.required]],
      userId: [UserService.loggedInUser.email,[ Validators.required]],
      satisfactionLevel: [ '', [Validators.required]],
      feedback: ['', [Validators.required]]
    });
  }

  submitFeedback(){
    this.user.addSiteFeedback(this.feedbackForm.value)
    .then(resp => {
      //swal
      console.log(resp);
      this.router.navigate(['/userHome']);
    })
  }


}

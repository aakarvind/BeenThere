import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-help-desk',
  templateUrl: './user-help-desk.component.html',
  styleUrls: ['./user-help-desk.component.css']
})
export class UserHelpDeskComponent implements OnInit {
helpdeskForm:FormGroup;
  constructor(private router:Router,private user:UserService,private fb:FormBuilder) {


   }

  ngOnInit() {

    this.helpdeskForm = this.fb.group({
      querySubject: ['',[ Validators.required]],
      userId: [UserService.loggedInUser.email,[ Validators.required]],
      query: ['', [Validators.required]],
      
    });
  }

  submitQuery(){
    this.user.raiseQuery(this.helpdeskForm.value)
    .then(resp => {
      //swal
      console.log(resp);
      this.router.navigate(['/userHome']);
    })
  }
}

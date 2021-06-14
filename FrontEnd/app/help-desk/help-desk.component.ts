import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-help-desk',
  templateUrl: './help-desk.component.html',
  styleUrls: ['./help-desk.component.css']
})
export class HelpDeskComponent implements OnInit {
  replyToQuery = false;
  allQueries;
  displayQueries: boolean = false;

  constructor(private adminService: AdminService) { 
    this.adminService.getAllUserQueries()
    .then(resp => {
      this.allQueries = resp;
      this.displayQueries = true;
    })
    .catch(err => {
      console.log(err);
    })
  }

  ngOnInit() {
  }

  action(){
    console.log('reply clicked');
    this.replyToQuery = true;
  }

  replyToThisQuery(){
    this.replyToQuery = false;
  }
}

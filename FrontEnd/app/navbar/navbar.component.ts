import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { UserSearchComponent } from '../user-search/user-search.component';
import { UserService } from '../user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private adminService: AdminService) { }

  ngOnInit() {
    console.log(AdminService.loggedInAdmin);
    console.log(UserService.loggedInUser);
  }

  loadUserProfile(){
    this.router.navigate(['/viewuser']);
  }
  

}

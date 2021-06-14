import { Component } from '@angular/core';
import { UserService } from './user.service';
import { AdminService } from './admin.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 

  constructor(private router:Router, private userService: UserService, private adminService: AdminService)
  {
    
  }
}

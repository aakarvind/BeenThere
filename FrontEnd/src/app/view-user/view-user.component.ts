import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { User } from '../model-classes/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {
  userNamesList = [] ;
  userStrList: [string];
  showTable: boolean = false;
  topContactedUsers: [User];
  MostTravellingUsers: [User];
  listOfMatchedUserStr = [];
  fetchedResult : boolean = false;
  listOfMatchedResults = [];
  noResultFound: boolean = false;
  dpic="https://www.ibts.org/wp-content/uploads/2017/08/iStock-476085198.jpg";

  constructor(private adminService: AdminService, private router: Router) { }

  ngOnInit() {
    this.adminService.getViewUsersComponentData()
    .then(resp => {
      this.userStrList = resp.userNamesForSearch;
      for(let name of this.userStrList){
        this.userNamesList.push(name.split(':')[0]); 
      }
      console.log(this.userNamesList);
      this.topContactedUsers = resp.topContactedUsers;
      this.MostTravellingUsers = resp.topTravellingUsers;
      console.log(this.topContactedUsers);
      console.log(this.MostTravellingUsers);
    })
    .catch(err => {
      console.log(err);
    })
  }

  textChanged(event: string){
    this.fetchedResult = false;
    this.noResultFound = false;
    this.listOfMatchedResults = [];
    console.log(event + " " + this.fetchedResult);
   
    if(event !== "") 
    {
      for(let i of this.userNamesList)
      {
        if(i.toLowerCase().indexOf(event) != -1) 
        {
          this.listOfMatchedResults.push(i);
          if(this.listOfMatchedResults.length == 3){
            break;
          }
        }
      }

      this.fetchedResult = true;
      console.log(this.listOfMatchedResults);
      console.log(this.fetchedResult);
    } 

    if(this.listOfMatchedResults.length == 0 ) {
      this.noResultFound = true;
    }
  }
   
  searchResultSelected(a) {
    this.fetchedResult = false;
   
    // console.log(a);
   
    // Selected option is set as text in search bar 
    (<HTMLInputElement>document.getElementById("searchInputField")).value = a;
   
    // console.log((<HTMLInputElement>document.getElementById("searchInputField")).value)
  }

  showUserDetails(userEmail: string){
    console.log(userEmail)
    this.adminService.getUserByEmail(userEmail.split('.')[0])
    .then(resp => {
      console.log(resp);
      this.router.navigate(['/adminuserviewprofile']);
    })
    .catch(err => {
      console.log(err);
    })
  }

  getMatchedUsers(){
    let searchStr = (<HTMLInputElement>document.getElementById("searchInputField")).value;
    this.listOfMatchedUserStr = [];
    this.showTable = false;
    // console.log('user str list = ' + this.userStrList);
    // console.log('user Names list = ' + this.userNamesList);

    for(let nameIndex in this.userNamesList){
      if(this.userNamesList[nameIndex].toLowerCase().indexOf(searchStr.toLowerCase()) != -1){
        this.listOfMatchedUserStr.push(this.userStrList[nameIndex]);
      }
    }

    // console.log(this.listOfMatchedUserStr);
    this.showTable = true;
  }

}

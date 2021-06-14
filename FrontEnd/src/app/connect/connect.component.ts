import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../model-classes/User';
import { Messgaes } from '../model-classes/Messages';
import { UserLoginComponent } from '../user-login/user-login.component';

@Component({
  selector: 'app-connect',
  templateUrl: './connect.component.html',
  styleUrls: ['./connect.component.css']
})
export class ConnectComponent implements OnInit {
 
  storeuserId:String;
  successMessage: string;
  errorMessage: string;
  users:User[]=[];
  friend:string;
  SearchForm:FormGroup;
  messages:Messgaes[]=[]
  messages2:Messgaes[]=[]
  garbage2:string;
  garbage:Messgaes;
  friendName:String;
  MyName:String;
  chatForm = this.fb.group({
    senderEmailId:['',[Validators.required]],
    reciverEmailId:['',[Validators.required]]
  })
  xy=false;

  MessageForm = this.fb.group({
    senderEmailId:['',[Validators.required]],
    reciverEmailId:['',[Validators.required]],
    data:['',[Validators.required]]
  })


  constructor( private fb:FormBuilder,private userservice: UserService ,private router: Router) {}

  
  search(){
    
    this.friend= this.SearchForm.controls.friendName.value
    for(let i=0; i<this.users.length; i++){
       if(this.users[i].email==this.friend){
        //  this.friendName=this.users[i].firstname+" "+this.users[i].lastname;
        this.friendName=this.users[i].name;
      
       }
 
    }
    // alert(JSON.stringify(this.friend))
    UserLoginComponent.tempstore = this.friend; 
    this.chatForm.get('senderEmailId').setValue(UserLoginComponent.userId);
    this.chatForm.get('reciverEmailId').setValue(this.friend);
    this.recive()  
    
    
  }

  refresh(){
    this.friend= this.SearchForm.controls.friendName.value
    // alert(JSON.stringify(this.friend))
    UserLoginComponent.tempstore = this.friend; 
    this.chatForm.get('senderEmailId').setValue(UserLoginComponent.userId);
    this.chatForm.get('reciverEmailId').setValue(this.friend);
    this.recive()
  }

  recive(){
    this.userservice.recive(this.chatForm.value)
    .then(res=>{this.messages=res;
      this.messages2 = this.messages;
      // this.messages2 = this.messages.reverse();
      console.log(this.messages);
     
      }
    )
    .catch(err=>alert(JSON.stringify("First Time Chat")))
  }

  store(){
    this.MessageForm.get('senderEmailId').setValue(UserLoginComponent.userId);
    this.MessageForm.get('reciverEmailId').setValue(this.friend);
    this.userservice.store(this.MessageForm.value)
    .then(res=>{this.garbage=res;
    // alert(JSON.stringify("message sent"))
    this.recive()
    this.garbage2="filled"
   
    this.router.navigate(['/chat'])
  })
    .catch(err=>alert(JSON.stringify("message not sent!!")))
  }

  ngOnInit() {
  
   
    this.storeuserId=UserLoginComponent.userId; 
    this.MyName=UserLoginComponent.usrs.name;
    this.userservice.getAllUsers()
    .then((res)=>{this.users=res;
      // alert(JSON.stringify("abc"))
      for(let i=0; i<this.users.length; i++){
        if(this.users[i].email==this.storeuserId){
          this.users.splice(i, 1);
          break;
        }
    } 
      console.log(this.users)
    })
    .catch(res=>this.errorMessage=res.message)
    
    if(UserLoginComponent.tempstore!=null){
      this.chatForm.get('senderEmailId').setValue(UserLoginComponent.userId);
      this.chatForm.get('reciverEmailId').setValue(UserLoginComponent.tempstore);
      this.recive()
    }
    else{
      // alert(JSON.stringify("new Chat"))
      this.SearchForm = this.fb.group({
        friendName:['',[Validators.required]]
      })
    }
     

    
    
  }
  xyz()
  {

    this.xy=true;
  }

}

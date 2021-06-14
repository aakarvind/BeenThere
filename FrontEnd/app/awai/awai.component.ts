import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-awai',
  templateUrl: './awai.component.html',
  styleUrls: ['./awai.component.css'],
  
})
export class AwaiComponent implements OnInit {
  errorMessage: string;
  successMessage: string;
  addCityForm: FormGroup;
  widt = 98;
  constructor(private fb: FormBuilder, private addcity:AdminService) { 

  }

  ngOnInit() {
    this.addCityForm = this.fb.group({
      name: ['', Validators.required]
    });
  }
  AddCity(){
    this.successMessage = null;
    this.errorMessage = null;
    console.log(JSON.stringify(this.addCityForm.value));
    this.addcity.addCity(this.addCityForm.value)
    .then(response => {
      this.successMessage=response.name;
      
      })
      .catch(error => {
        this.errorMessage = error.name;
        
      })
  }

  // (<HTMLInputElement>document.getElementById("pppop")).width = 500px;
      // console.log((<HTMLInputElement>document.getElementsByClassName("w3-grey")).width);
}



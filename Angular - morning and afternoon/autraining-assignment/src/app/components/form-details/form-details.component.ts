import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form-details',
  templateUrl: './form-details.component.html',
  styleUrls: ['./form-details.component.css']
})
export class FormDetailsComponent implements OnInit {

  firstName = ""
  lastName = ""
  gender = ""
  dateOfBirth = ""
  phoneNumber = ""
  marksTenth = ""
  marksTwelth = ""

  constructor(private router: Router) { 
    this.firstName = this.router.getCurrentNavigation().extras.state.formData.firstName;
    this.lastName = this.router.getCurrentNavigation().extras.state.formData.lastName;
    this.gender = this.router.getCurrentNavigation().extras.state.formData.gender;
    this.dateOfBirth = this.router.getCurrentNavigation().extras.state.formData.dateOfBirth;
    this.phoneNumber = this.router.getCurrentNavigation().extras.state.formData.phoneNumber;
    this.marksTenth = this.router.getCurrentNavigation().extras.state.formData.marksTenth;
    this.marksTwelth = this.router.getCurrentNavigation().extras.state.formData.marksTwelth;
  }

  ngOnInit(): void {
  }

}

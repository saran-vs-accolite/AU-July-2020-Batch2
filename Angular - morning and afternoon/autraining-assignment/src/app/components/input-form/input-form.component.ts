import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-input-form',
  templateUrl: './input-form.component.html',
  styleUrls: ['./input-form.component.css']
})
export class InputFormComponent implements OnInit {
  constructor(
    private fb: FormBuilder,
    private router: Router
  ){}

  userProfile: FormGroup;

  ngOnInit() : void {
    this.userProfile = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      gender: ['', [Validators.required, Validators.maxLength(1), Validators.pattern("[MFO]")]],
      dateOfBirth: ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(10), Validators.pattern("^[0-9]*$")]],
      marksTwelth: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.min(0), Validators.max(1200)]],
      marksTenth: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.min(0), Validators.max(500)]],
    })
  }

  displayDetails = () => {
    if(this.userProfile.valid)
      this.router.navigateByUrl('formDetails', {state: {formData: this.userProfile.value}})
    else
      console.log("Form has errors")
  }

  isInvalid(field : string) {
    return !this.userProfile.get(field).valid
  }


}
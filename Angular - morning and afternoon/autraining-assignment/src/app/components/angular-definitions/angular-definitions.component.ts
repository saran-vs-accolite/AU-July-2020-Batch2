import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Component({
  selector: 'app-angular-definitions',
  templateUrl: './angular-definitions.component.html',
  styleUrls: ['./angular-definitions.component.css']
})
export class AngularDefinitionsComponent implements OnInit {

  definitions : any

  constructor(private httpClient: HttpClient) { 
    httpClient.get("https://demo3463355.mockable.io/getDefinitions").subscribe((data: any) => (this.definitions = data.definitions))
  }

  ngOnInit(): void {
  }

}

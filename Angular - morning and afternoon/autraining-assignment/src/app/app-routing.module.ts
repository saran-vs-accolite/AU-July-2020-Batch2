import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InputFormComponent } from './components/input-form/input-form.component';
import { FormDetailsComponent } from './components/form-details/form-details.component';
import { AngularDefinitionsComponent } from './components/angular-definitions/angular-definitions.component';
import { HomePageComponent } from './components/home-page/home-page.component';

const routes: Routes = [
  {
    path: "home",
    component: HomePageComponent
  },
  
  {
    path: "inputForm",
    component: InputFormComponent
  },

  {
    path: "formDetails",
    component: FormDetailsComponent
  },

  {
    path: "angularDefinitions",
    component: AngularDefinitionsComponent
  },

  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

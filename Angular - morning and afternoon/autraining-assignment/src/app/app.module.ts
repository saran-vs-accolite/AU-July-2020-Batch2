import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InputFormComponent } from './components/input-form/input-form.component';
import { FormDetailsComponent } from './components/form-details/form-details.component';
import { AngularDefinitionsComponent } from './components/angular-definitions/angular-definitions.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomePageComponent } from './components/home-page/home-page.component'
import { HttpClientModule } from '@angular/common/http';
import { ConcatPipe } from './pipes/concat.pipe';

@NgModule({
  declarations: [
    AppComponent,
    InputFormComponent,
    FormDetailsComponent,
    AngularDefinitionsComponent,
    HomePageComponent,
    ConcatPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

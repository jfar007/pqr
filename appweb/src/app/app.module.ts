import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { HttpClientModule} from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PqrComponent } from './pqr/pqr.component';
import { InfoComponent } from './info/info.component';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    PqrComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

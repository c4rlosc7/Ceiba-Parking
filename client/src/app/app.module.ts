import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { VehiculosComponent } from './vehiculos/vehiculos.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    VehiculosComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

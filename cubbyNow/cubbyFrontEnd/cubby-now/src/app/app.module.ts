import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GlobalhomeComponent } from './components/globalhome/globalhome.component';
import { LoginbarComponent } from './components/loginbar/loginbar.component';

@NgModule({
  declarations: [
    AppComponent,
    GlobalhomeComponent,
    LoginbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

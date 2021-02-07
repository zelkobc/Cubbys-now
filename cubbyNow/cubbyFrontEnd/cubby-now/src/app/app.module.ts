import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GlobalhomeComponent } from './components/globalhome/globalhome.component';
import { LoginbarComponent } from './components/loginbar/loginbar.component';
import { HttpClientModule } from '@angular/common/http';
import { MessagingComponent } from './components/messaging/messaging.component';
import { FormsModule } from '@angular/forms';
import { LeftNavbarComponent } from './components/left-navbar/left-navbar.component';
import { RightNavbarComponent } from './components/right-navbar/right-navbar.component';
import { CommonModule } from '@angular/common';
import { ViewmessagesComponent } from './components/viewmessages/viewmessages.component';
import { VotingComponent } from './components/voting/voting.component';  
import { ViewGroupsComponent } from './components/view-groups/view-groups.component';
import {PostPageComponent} from './components/post-page/post-page.component';
import {PostComponent} from './components/post/post.component';

@NgModule({
  declarations: [
    AppComponent,
    GlobalhomeComponent,
    LoginbarComponent,
    MessagingComponent,
    LeftNavbarComponent,
    RightNavbarComponent,
    ViewmessagesComponent,
    VotingComponent,
    ViewGroupsComponent,
    PostPageComponent,
    PostComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClassCalendarComponent } from './components/class-calendar/class-calendar.component';
import { GlobalhomeComponent } from './components/globalhome/globalhome.component';
import {PostPageComponent} from './components/post-page/post-page.component';
import { ViewmessagesComponent } from './components/viewmessages/viewmessages.component'

const routes: Routes = [
  {
    path: 'home',
    component: GlobalhomeComponent
  },
  {
    path: 'posts',
    component: PostPageComponent
  },
  {
    path: 'messaging',
    component: ViewmessagesComponent
  },
  {
    path: 'calendar',
    component: ClassCalendarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

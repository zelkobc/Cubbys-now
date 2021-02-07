import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GlobalhomeComponent } from './components/globalhome/globalhome.component';
import {PostPageComponent} from './components/post-page/post-page.component';
import { MessagingComponent } from './components/messaging/messaging.component';

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
    component: MessagingComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

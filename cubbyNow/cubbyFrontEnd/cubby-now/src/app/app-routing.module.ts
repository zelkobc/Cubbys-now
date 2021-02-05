import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GlobalhomeComponent } from './components/globalhome/globalhome.component';
import {PostPageComponent} from './components/post-page/post-page.component';

const routes: Routes = [
  {
    path: 'home',
    component: GlobalhomeComponent
  },
  {
    path: 'posts',
    component: PostPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

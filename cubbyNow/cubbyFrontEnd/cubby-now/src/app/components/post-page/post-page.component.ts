import { Component, OnInit } from '@angular/core';
import {Post} from 'src/app/models/post';
import {PostService} from 'src/app/services/post.service';

@Component({
  selector: 'app-post-page',
  templateUrl: './post-page.component.html',
  styleUrls: ['./post-page.component.css']
})
export class PostPageComponent implements OnInit {
  postArray: Post[] = [];

  constructor(private postServ:PostService) { }

  ngOnInit(): void {
    this.refresh();
  }

  refresh(){
    this.postServ.getPublicPosts().subscribe(
      resp => {
        this.postArray = resp as Post[];
        console.log(resp);
        console.log(this.postArray);
      }
    );
  }
}

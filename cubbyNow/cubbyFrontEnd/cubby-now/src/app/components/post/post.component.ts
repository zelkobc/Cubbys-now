import { Component, Input, OnInit } from '@angular/core';
import {Post} from 'src/app/models/post';
import {User} from 'src/app/models/user';
import {PostService} from 'src/app/services/post.service';
import {UserService} from 'src/app/services/user.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input() post: Post;
  author: User;
  loggedUser: User;
  commentArray: Comment[];

  
  constructor(private postServ: PostService, private userServ: UserService) { }

  ngOnInit(): void {
    this.userServ.getUserById(this.post.authorid).subscribe(
      resp => {
        this.author = resp;
      }
    );
  }

  commentButton(newComment: string){
  }

  editButton(newContent: string){
  }

  refresh(){
    this.postServ.getPostById(this.post.postid).subscribe(
      resp => {
        this.post = resp;
      }
    );
    
  }
}

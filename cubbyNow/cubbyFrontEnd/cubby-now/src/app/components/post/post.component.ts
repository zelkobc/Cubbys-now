import { Component, Input, OnInit } from '@angular/core';
import {Post} from 'src/app/models/post';
import {Reply} from 'src/app/models/reply';
import {User} from 'src/app/models/user';
import {PostService} from 'src/app/services/post.service';
import {ReplyService} from 'src/app/services/reply.service';
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
  replyArray: Reply[] = [];

  
  constructor(private postServ: PostService, private userServ: UserService, private replyServ: ReplyService) { }

  ngOnInit(): void {
    this.refresh();
  }

  replyButton(newReply: string){
    this.refresh();
  }

  editButton(newMessage: string){
    this.refresh();
  }

  refresh(){
    this.postServ.getPostById(this.post.postid).subscribe(
      resp => {
        this.post = resp;
      }
    );
    
    this.userServ.getUserById(this.post.authorid).subscribe(
      resp => {
        this.author = resp;
      }
    );
 
    this.replyServ.getRepliesByPost(this.post.postid).subscribe(
      resp => {
        this.replyArray = resp;
      }
    )
  }
}

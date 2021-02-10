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
  @Input() inputPost: Post;
  author: User;
  loggedUser: User = JSON.parse(window.sessionStorage.user);
  replyArray: Reply[] = [];
  replyInput: string;
  
  constructor(private postServ: PostService, private userServ: UserService, private replyServ: ReplyService) { }

  ngOnInit(): void {
    console.log("post: " + this.inputPost.content);
    this.refresh();
  }

  replyButton(){
    let reply: Reply = new Reply();
    reply.message = (this.replyInput);
    reply.post = this.inputPost;
    reply.author = this.loggedUser;
    console.log(reply.message);
    console.log(reply);
    this.replyServ.addReply(reply).subscribe(
      resp => {
        this.refresh();
      }
    );
  }

  editButton(newMessage: string){
    this.refresh();
  }

  refresh(){
    this.postServ.getPostById(this.inputPost.postid).subscribe(
      resp => {
        this.inputPost = resp as Post;
      }
    );
    
    this.userServ.getUserById(this.inputPost.authorid).subscribe(
      resp => {
        console.log(resp as User);
        this.author = resp as User;
        console.log(this.author.username);
      }
    );
 
    this.replyServ.getRepliesByPost(this.inputPost.postid).subscribe(
      resp => {
        this.replyArray = resp as Reply[];
      }
    )
  }
}

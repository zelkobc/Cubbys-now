import { Component, Input, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { User } from 'src/app/models/user';
import { Vote } from 'src/app/models/vote';
import { PostService } from 'src/app/services/post.service';
import { UserService } from 'src/app/services/user.service';
import { VoteService } from 'src/app/services/vote.service';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit {
  voteCount: number;
  votes: Vote[];
  newVote: Vote;
  voteTotal: number;
  voteAvg: number;
  loggedUser = JSON.parse(window.sessionStorage.user);
  @Input() relPost: Post;
  voteStatus: Boolean;

  constructor(private voteService:VoteService, private userService:UserService, private postService:PostService) { }

  ngOnInit(): void {
    this.getAllVotes(this.relPost.postid)
    this.checkVote(this.relPost.postid)
  }

  getAllVotes(id:number) {
    this.voteService.getVotesByPost(id).subscribe(
      resp=> {
        this.votes = resp;
        this.voteCount = resp.length;
        console.log(this.voteCount);
        this.voteTotal = resp.map(vote => vote.rating).reduce((a, b) => {return a + b});
        console.log(this.voteTotal);
      }
    )
  }
  checkVote(id:number) {
    this.voteService.checkVote(id, this.loggedUser.id).subscribe(
      resp=> {
        this.voteStatus = resp;
      }
    )
  }
  setVote(rating: number) {
    this.newVote = new Vote;
    this.newVote.rating = rating;
    this.newVote.userid = JSON.parse(window.sessionStorage.user).id;
    this.newVote.postid = this.relPost.postid;
    this.voteService.setVote(this.newVote).subscribe();
  }
  getVoteById(id:number) {

  }
  updateVote(rating: number) {

  }

}

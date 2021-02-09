import { Component, OnInit } from '@angular/core';
import { Group } from 'src/app/models/group';
import { Post } from 'src/app/models/post';
import { GroupService } from 'src/app/services/group.service';
import { PostService } from 'src/app/services/post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-one-group',
  templateUrl: './view-one-group.component.html',
  styleUrls: ['./view-one-group.component.css']
})
export class ViewOneGroupComponent implements OnInit {

  posts: Post[];
  group: Group
  constructor(private groupService: GroupService, private postService: PostService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      resp => {this.groupService.getGroupById(resp['groupid']).subscribe(
        resp => {this.group = resp; this.postService.getGroupPosts(this.group.id).subscribe(
          resp => this.posts = resp as Post[])}
      )}
    );

  }

}

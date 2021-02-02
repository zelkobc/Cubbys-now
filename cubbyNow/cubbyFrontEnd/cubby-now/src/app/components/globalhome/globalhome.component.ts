import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { UrlService } from 'src/app/services/url.service';

@Component({
  selector: 'app-globalhome',
  templateUrl: './globalhome.component.html',
  styleUrls: ['./globalhome.component.css']
})
export class GlobalhomeComponent implements OnInit {

  url: string;

  constructor(private http: HttpClient, private urlServ: UrlService) {this.url = urlServ.getUrl() + "posts" }

  ngOnInit(): void {
  }

  addPost(post: Post)
  {
    return this.http.post(this.url,JSON.stringify(post));
  }

  getPostById(id: number)
  {
    return this.http.get(this.url + "/" + id);
  }

  getAllPosts()
  {
    return this.http.get(this.url + "/all");
  }

  updatePost(post: Post)
  {
    return this.http.put(this.url, post);
  }

  deletePostById(id: number)
  {
    return this.http.delete(this.url + "/" + id);
  }

}

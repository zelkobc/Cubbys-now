import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Reply} from '../models/reply';
import {UrlService} from './url.service';

@Injectable({
  providedIn: 'root'
})
export class ReplyService {
  url: string;
  private regHeaders = this.urlServ.regHeaders;

  constructor(private http: HttpClient, private urlServ: UrlService) { 
    this.url = urlServ.getUrl() + "replies" 
  }

  ngOnInit(): void{}

  addReply(reply: Reply){
    return this.http.post(this.url, JSON.stringify(reply), {headers: this.regHeaders, withCredentials:true});
  }

  getReplyById(id: number){
    return this.http.get(this.url + "/" + id);
  }

  getRepliesByPost(id: number){
    return this.http.get(this.url + "/posts/" + id);
  }

  getAllReplies(){
    return this.http.get(this.url);
  }

  updateReply(reply: Reply){
    return this.http.put(this.url, reply, {headers: this.regHeaders, withCredentials:true});
  }

  deleteReplyById(id: number){
    return this.http.delete(this.url + "/" + id);
  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { Vote } from '../models/vote';
import { UrlService } from './url.service';

@Injectable({
  providedIn: 'root'
})
export class VoteService {
  private regHeaders = this.urlService.regHeaders;
  userVotesUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) {
    this.userVotesUrl = this.urlService.getUrl() + 'posts/votes/'
   }
   // we want to make a section in html to display the output of a calculation on the set of votes, like the average vote or, for polling, most common choice
   getVotesByPost(id: number): Observable<Vote[]> {
     return this.http.get(this.userVotesUrl + id +'/', {headers: this.regHeaders, withCredentials:true}).pipe(
       map(resp => resp as Vote[])
     );
   }
   setVote(newVote: Vote): Observable<object> {
     return this.http.post(this.userVotesUrl, newVote, {headers:this.regHeaders, withCredentials:true}).pipe(
       map(resp => resp as Vote)
     );
   }
   checkVote(id: number, userid: number): Observable<number> {
     return this.http.get(this.userVotesUrl + 'check/' + id + '/' + userid, {headers: this.regHeaders, withCredentials:true}).pipe(
      map(resp => resp as number)
     )
   }
   updateVote(vote: Vote): Observable<object> {
     return this.http.put(this.userVotesUrl, vote, {headers: this.regHeaders, withCredentials: true}).pipe(
       map(resp=> resp as Vote)
     )
   }
}

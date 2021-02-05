import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlService } from '../services/url.service';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { Message } from '../models/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  userMessagesUrl: string;

  private regHeaders = this.urlService.regHeaders;

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) {
    this.userMessagesUrl = this.urlService.getUrl() + 'messages/'
   }
   getMessages(id: Number): Observable<Message[]> {
     return this.http.get(this.userMessagesUrl + 'user/' + id, {withCredentials:true}).pipe(
       map(resp => resp as Message[])
     );
   }
   writeMessage(userMessage: Message): Observable<object> {
     return this.http.post(this.userMessagesUrl, Message, {headers: this.regHeaders, withCredentials:true}).pipe(
       map(resp => resp as Message)
     )
   }
}

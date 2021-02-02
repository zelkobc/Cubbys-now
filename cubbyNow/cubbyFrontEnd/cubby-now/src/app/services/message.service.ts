import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlService } from '../url.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  userMessagesUrl: string;
  private formHeaders = this.urlService.formHeaders;
  private regHeaders = this.urlService.regHeaders;

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) {
    this.userMessagesUrl = this.urlService.getUrl() + 'messages/'
   }
   getMessages(id: Number): Observable<Message[]> {
     return this.http.get(this.userMessagesUrl + id, {withCredentials:true}).pipe(
       map(resp => resp as Message[])
     );
   }
   writeMessage(userMessage: Message): Observable<object> {
     return this.http.post(this.userMessagesUrl, Message, {headers: this.regHeaders, withCredentials:true}).pipe(
       map(resp => resp as Message)
     )
   }
}

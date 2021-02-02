import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service'
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UrlService {
  formHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSONID'), 'Content-Type': 'application/x-www-form-urlencoded'});
  regHeaders = new HttpHeaders({'Cookie':this.cookieService.get('JSESSIONID'), 'Content-Type': 'application/json'});

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) { 
  }

  getUrl(): string {
    return 'http://localhost:8080/';
  }

}

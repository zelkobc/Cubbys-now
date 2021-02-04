import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UrlService } from './url.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private loggedUser: User;
  private usersUrl: string;

  constructor(private http: HttpClient, private urlService: UrlService, private cookieService: CookieService) {
    this.usersUrl = this.urlService.getUrl() + 'users';
  }

  loginUser(username: string, password: string): Observable<User> {
    if (username && password) {
      const queryParams = `?user=${username}&pass=${password}`;
      return this.http.put(this.usersUrl +'/login' + queryParams,
        {headers: this.urlService.formHeaders, withCredentials:true}).pipe(
          map(resp => resp as User)
      );
    } else {
      return this.http.get(this.usersUrl,
        {withCredentials:true}).pipe(
          map(resp => resp as User)
        );
    }
  }

  logoutUser(): Observable<object> {
    return this.http.delete(this.usersUrl, {headers:this.urlService.regHeaders, withCredentials:true}).pipe();
  }

  updateUser(updatedUser: User): Observable<object> {
    this.loggedUser = updatedUser;
    return this.http.put(this.usersUrl + this.loggedUser.id, updatedUser, 
      {headers:this.urlService.regHeaders, withCredentials:true}).pipe();
  }

  getLoggedUser(): User {
    return this.loggedUser;
  }

  getUserById(id: number): Observable<User> {
    return this.http.get(this.usersUrl + id, {headers:this.urlService.regHeaders, withCredentials:true}).pipe(
      map((resp) => resp as User)
    );
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get(this.usersUrl, {withCredentials:true}).pipe(
      map(resp => resp as User[])
    );
  }

  getUserbyUsername(name: string): Observable<User> {
    return this.http.get(this.usersUrl + '/username/' + name, { withCredentials: true })
    .pipe(map((resp) => resp as User));
  }

}

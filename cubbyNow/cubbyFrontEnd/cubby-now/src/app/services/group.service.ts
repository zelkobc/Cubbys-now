import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Group } from '../models/group';
import { UrlService } from './url.service';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  url: string;

  constructor(private http: HttpClient, private urlServ: UrlService) { 
    this.url = this.urlServ + "groups";
  }

  addGroup(group: Group)
  {
    return this.http.post(this.url, group, {headers:this.urlServ.regHeaders, withCredentials:true}).pipe(
      map((resp) => resp as number)
    );
  }

  getGroupById(id: number)
  {
    return this.http.get(this.url + "/" + id, {headers:this.urlServ.regHeaders, withCredentials:true}).pipe(
      map((resp) => resp as Group)
    );
  }

  getAllGroups()
  {
    return this.http.get(this.url, {headers:this.urlServ.regHeaders, withCredentials:true}).pipe(
      map((resp) => resp as Group[])
    );
  }

  updateGroup(group: Group)
  {
    return this.http.put(this.url, group, {headers:this.urlServ.regHeaders, withCredentials:true}).pipe()
  }

  deleteGroupById(id: number)
  {
    return this.http.delete(this.url + "/" + id, {headers:this.urlServ.regHeaders, withCredentials:true}).pipe()
  }

}

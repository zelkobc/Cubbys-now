import { Component, Input, OnInit } from '@angular/core';
import { Message } from 'src/app/models/message';
import { User } from 'src/app/models/user';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-viewmessages',
  templateUrl: './viewmessages.component.html',
  styleUrls: ['./viewmessages.component.css']
})
export class ViewmessagesComponent implements OnInit {
  Messages: Message[];
  loggedUser: User;
  loggedUserRole: number;
  adminFlag: number;
  alert: string;
  constructor(private messageService:MessageService, private userService:UserService) {
   }

  ngOnInit(): void {
    if(window.sessionStorage.user) {
    this.messageService.getMessages(JSON.parse(window.sessionStorage.user).id).subscribe(
      resp=> {
        this.Messages = resp;
        console.log(this.Messages);
      }
    );
    }
    if(window.sessionStorage.user) {
      this.loggedUser = JSON.parse(window.sessionStorage.user)
    } else {
      this.loggedUser = null;
    }
    if(JSON.parse(window.sessionStorage.user)) {
      this.loggedUserRole= JSON.parse(window.sessionStorage.user).role.id;
    
    if((JSON.parse(window.sessionStorage.user).role.id > 1)) {

      this.adminFlag = 1;
    }
  } else {
    this.alert = "You are not logged in!"
  }
  }
}

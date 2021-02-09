import { Component, OnInit } from '@angular/core';
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
  loggedUser: User = window.sessionStorage.user
  loggedUserRole: number = JSON.parse(window.sessionStorage.user).role.id;
  adminFlag: number;
  constructor(private messageService:MessageService, private userService:UserService) {
   }

  ngOnInit(): void {
    this.messageService.getMessages(JSON.parse(window.sessionStorage.user).id).subscribe(
      resp=> {
        this.Messages = resp;
        console.log(this.Messages);
      }
    );
    if(this.loggedUserRole > 1) {
      this.adminFlag = 1;
    }
  }
}

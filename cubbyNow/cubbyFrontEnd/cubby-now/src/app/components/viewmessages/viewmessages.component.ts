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
  hasFlag: number;
  loggedUser: User = window.sessionStorage.user
  constructor(private messageService:MessageService, private userService:UserService) {
   }

  ngOnInit(): void {
    this.messageService.getMessages(JSON.parse(window.sessionStorage.user).id).subscribe(
      resp=> {
        this.Messages = resp;
        console.log(this.Messages);
      }
    );
  }

}

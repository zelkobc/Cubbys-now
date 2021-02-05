import { Component, Input, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { User } from '../../models/user';
import { Message } from '../../models/message'
import { CommonModule } from '@angular/common';  
import { BrowserModule } from '@angular/platform-browser';
import { UrlService } from '../../services/url.service';
import { MessageService } from '../../services/message.service'
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-messaging',
  templateUrl: './messaging.component.html',
  styleUrls: ['./messaging.component.css']
})
export class MessagingComponent implements OnInit {
message: string;
target: number;
newMessage: Message;
Messages: Message[];
Users: User[];
hasFlag: number;
authFlag: number;
@Input() loggedUser: User = window.sessionStorage.user;

  constructor(private messageService:MessageService, private userService:UserService) {
   }

  ngOnInit(): void {
    console.log(this.loggedUser)
    this.messageService.getMessages(JSON.parse(window.sessionStorage.user).id).subscribe(
      resp=> {
        this.Messages = resp;
      }
    )
    
    if(this.Messages.length == 0) {
      this.hasFlag = 0;
    } else {
      this.hasFlag = 1;
    }
    if(this.loggedUser.role.id > 1) {
      this.authFlag = 1;
    } else {
      this.authFlag = 0;
    }
    this.userService.getAllUsers().subscribe(
      resp=> {
        this.Users = resp;
      }
    )
    console.log(this.hasFlag)
  }
onSubmit() {
  this.newMessage = new Message;
  this.newMessage.content = this.message;
  this.newMessage.writer.id = this.loggedUser.id;
  this.newMessage.receiver.id = this.target;
  this.messageService.writeMessage(this.newMessage).subscribe();
}
}

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
alert: string;
messageString: string;
@Input() loggedUser: User = JSON.parse(window.sessionStorage.user);
roleFlag: number;

  constructor(private messageService:MessageService, private userService:UserService) {
   }

  ngOnInit(): void {
    if(JSON.parse(window.sessionStorage.user).role.id > 1){
      this.roleFlag = 1;
    this.getUsers();
    }
    this.messageService.getMessages(JSON.parse(window.sessionStorage.user).id).subscribe(
      resp=> {
        this.Messages = resp;
        if(this.Messages.length > 0) {
          this.hasFlag = 1;
        }
      }
    );
  }
onSubmit() {
  this.newMessage = new Message;
  this.newMessage.content = this.message;
  this.newMessage.writer = JSON.parse(window.sessionStorage.user);
  this.newMessage.receiver = new User;
  this.newMessage.receiver.id = this.target;
  this.messageService.writeMessage(this.newMessage).subscribe();
  console.log(this.newMessage);
}
getUsers() {
  this.userService.getAllUsers().subscribe(
  resp=> {
    this.Users = resp;
    console.log(this.Users)
  }
  );
}
}

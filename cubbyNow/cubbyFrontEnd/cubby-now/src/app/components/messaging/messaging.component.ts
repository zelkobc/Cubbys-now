import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { Message } from '../../models/message'
import { UrlService } from '../../services/url.service';
import { MessageService } from '../../services/message.service'

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
@Input() public loggedUser: User;

  constructor(private messageService:MessageService) {
   }

  ngOnInit(): void {
    this.messageService.getMessages(this.loggedUser.id).subscribe(
      resp=> {
        this.Messages = resp;
      }
    )
    if(this.Messages.length == 0) {
      var hasFlag = 0;
    } else {
      var hasFlag = 1;
    }
  }
onSubmit() {
  this.newMessage = new Message;
  this.newMessage.content = this.message;
  this.newMessage.writerid = this.loggedUser.id;
  this.newMessage.receiverid = this.target;
  this.messageService.writeMessage(this.newMessage).subscribe();
}
}

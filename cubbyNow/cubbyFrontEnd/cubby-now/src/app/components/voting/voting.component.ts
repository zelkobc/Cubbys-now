import { Component, OnInit } from '@angular/core';
import { MessageService } from 'src/app/services/message.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-voting',
  templateUrl: './voting.component.html',
  styleUrls: ['./voting.component.css']
})
export class VotingComponent implements OnInit {

  constructor(private messageService:MessageService, private userService:UserService) { }

  ngOnInit(): void {
  }

}

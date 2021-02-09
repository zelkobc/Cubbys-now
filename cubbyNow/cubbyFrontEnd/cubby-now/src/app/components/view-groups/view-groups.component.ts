import { Component, OnInit } from '@angular/core';
import { Group } from 'src/app/models/group';
import { User } from 'src/app/models/user';
import { GroupService } from 'src/app/services/group.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-view-groups',
  templateUrl: './view-groups.component.html',
  styleUrls: ['./view-groups.component.css']
})
export class ViewGroupsComponent implements OnInit {


  groups: Group[];
  message: string;
  done: boolean = false;


  constructor(private userService: UserService) { 
    this.fillGroups();
    
    
  }

  ngOnInit(): void {
  }

  fillGroups()
  {
    let person = JSON.parse(window.sessionStorage.getItem("user"));
    if (person)
    {
      this.groups = person.groups;
      this.message = "All Groups"
    }
    else
    {
      this.message = "Please log in to view groups!"
    }
    this.done = true;
  }

}

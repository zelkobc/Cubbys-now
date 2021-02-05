import { Component, OnInit } from '@angular/core';
import { Group } from 'src/app/models/group';
import { GroupService } from 'src/app/services/group.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-view-groups',
  templateUrl: './view-groups.component.html',
  styleUrls: ['./view-groups.component.css']
})
export class ViewGroupsComponent implements OnInit {


  groups: Group[];


  constructor(private userService: UserService) { 
    this.userService.getUserById(3).subscribe(
      resp => {
        window.sessionStorage.setItem("user", JSON.stringify(resp));
        this.fillGroups();
      }
    );
    
    
  }

  ngOnInit(): void {
  }

  fillGroups()
  {
    let person = JSON.parse(window.sessionStorage.getItem("user"));
    if (person)
    {
      this.groups = person.groups;
      console.log(this.groups);
    }
  }

}

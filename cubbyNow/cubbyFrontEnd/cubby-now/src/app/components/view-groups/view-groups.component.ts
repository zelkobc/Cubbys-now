import { Component, OnInit } from '@angular/core';
import { Group } from 'src/app/models/group';
import { User } from 'src/app/models/user';
import { GroupService } from 'src/app/services/group.service';
import { UserService } from 'src/app/services/user.service';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-view-groups',
  templateUrl: './view-groups.component.html',
  styleUrls: ['./view-groups.component.css']
})
export class ViewGroupsComponent implements OnInit {


  groups: Group[];
  message: string;
  done: boolean = false;
  teacher: boolean = false;
  students: User[];
  groupName: string;

  constructor(private userService: UserService, private groupService: GroupService) { 
    this.fillGroups();
    
    
  }

  ngOnInit(): void {
  }

  //gets all students associated with a teacher
  getStudents()
  {
    let person = JSON.parse(window.sessionStorage.getItem("user")) as User;
    this.userService.getUsersByTeacherId(person.id).subscribe(
      resp => this.students = resp
    );
  }

  createGroup()
  {
    let boxes = forms
    let selected: User[] = new Array<User>();
    for(let i = 0; i < boxes.length; i++)
    {
      console.log(boxes.item(i))
      if (boxes.item(i).getAttribute("checked"))
      {
        let studentid: number = parseInt(boxes.item(i).getAttribute("id"));
        console.log(studentid)
        for(let student of this.students)
        {
          if(student.id == studentid)
          {
            selected.push(student);
          }
        }
      }
    }

    let newGroup: Group = new Group();
    newGroup.name = this.groupName;
    this.groupService.addGroup(newGroup).subscribe(
      resp => {
        newGroup.id = resp;
        for(let student of selected)
        {
          student.groups.push(newGroup);
          this.userService.updateUser(student).subscribe();
        }
      }
    );
    
  }

  fillGroups()
  {
    let person = JSON.parse(window.sessionStorage.getItem("user")) as User;
    if (person)
    {
      this.groups = person.groups;
      this.message = "All Groups"
      if (person.role.id == 9)
      {
        this.teacher = true;
        this.getStudents();
      }
    }
    else
    {
      this.message = "Please log in to view groups!"
    }
    this.done = true;
  }

}

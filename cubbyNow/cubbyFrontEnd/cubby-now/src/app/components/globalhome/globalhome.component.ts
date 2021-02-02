import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-globalhome',
  templateUrl: './globalhome.component.html',
  styleUrls: ['./globalhome.component.css']
})
export class GlobalhomeComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  public addPost()
  {

  }

}

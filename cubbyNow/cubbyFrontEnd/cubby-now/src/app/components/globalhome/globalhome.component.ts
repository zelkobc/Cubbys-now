import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post';
import { UrlService } from 'src/app/services/url.service';

@Component({
  selector: 'app-globalhome',
  templateUrl: './globalhome.component.html',
  styleUrls: ['./globalhome.component.css']
})
export class GlobalhomeComponent implements OnInit {

  url: string;

  constructor() {}

  ngOnInit(): void {
  }


}

import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';

@Component({
  selector: 'app-class-calendar',
  templateUrl: './class-calendar.component.html',
  styleUrls: ['./class-calendar.component.css']
})
export class ClassCalendarComponent implements OnInit {

  calendarOptions: CalendarOptions = {
    initialView: 'dayGridMonth'
  };

  constructor() { }

  ngOnInit(): void {
  }

}

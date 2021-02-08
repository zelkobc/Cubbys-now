import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassCalendarComponent } from './class-calendar.component';

describe('ClassCalendarComponent', () => {
  let component: ClassCalendarComponent;
  let fixture: ComponentFixture<ClassCalendarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassCalendarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassCalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GlobalhomeComponent } from './globalhome.component';

describe('GlobalhomeComponent', () => {
  let component: GlobalhomeComponent;
  let fixture: ComponentFixture<GlobalhomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GlobalhomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GlobalhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

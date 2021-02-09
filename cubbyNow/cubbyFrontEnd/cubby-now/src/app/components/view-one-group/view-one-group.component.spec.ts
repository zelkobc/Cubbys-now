import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOneGroupComponent } from './view-one-group.component';

describe('ViewOneGroupComponent', () => {
  let component: ViewOneGroupComponent;
  let fixture: ComponentFixture<ViewOneGroupComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewOneGroupComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewOneGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

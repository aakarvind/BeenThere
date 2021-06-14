import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserHelpDeskComponent } from './user-help-desk.component';

describe('UserHelpDeskComponent', () => {
  let component: UserHelpDeskComponent;
  let fixture: ComponentFixture<UserHelpDeskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserHelpDeskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserHelpDeskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewPlaceComponent } from './user-view-place.component';

describe('UserViewPlaceComponent', () => {
  let component: UserViewPlaceComponent;
  let fixture: ComponentFixture<UserViewPlaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserViewPlaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

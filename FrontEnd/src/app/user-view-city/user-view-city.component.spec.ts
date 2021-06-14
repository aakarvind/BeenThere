import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewCityComponent } from './user-view-city.component';

describe('UserViewCityComponent', () => {
  let component: UserViewCityComponent;
  let fixture: ComponentFixture<UserViewCityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserViewCityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

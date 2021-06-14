import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddCityComponent } from './admin-add-city.component';

describe('AdminAddCityComponent', () => {
  let component: AdminAddCityComponent;
  let fixture: ComponentFixture<AdminAddCityComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddCityComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

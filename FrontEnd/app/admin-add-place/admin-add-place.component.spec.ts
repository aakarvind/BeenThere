import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddPlaceComponent } from './admin-add-place.component';

describe('AdminAddPlaceComponent', () => {
  let component: AdminAddPlaceComponent;
  let fixture: ComponentFixture<AdminAddPlaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAddPlaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewPlaceTrafficStatsComponent } from './admin-view-place-traffic-stats.component';

describe('AdminViewPlaceTrafficStatsComponent', () => {
  let component: AdminViewPlaceTrafficStatsComponent;
  let fixture: ComponentFixture<AdminViewPlaceTrafficStatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminViewPlaceTrafficStatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewPlaceTrafficStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

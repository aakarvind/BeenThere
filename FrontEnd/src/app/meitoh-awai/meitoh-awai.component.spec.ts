import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MeitohAwaiComponent } from './meitoh-awai.component';

describe('MeitohAwaiComponent', () => {
  let component: MeitohAwaiComponent;
  let fixture: ComponentFixture<MeitohAwaiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MeitohAwaiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MeitohAwaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

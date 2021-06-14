import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AwaiComponent } from './awai.component';

describe('AwaiComponent', () => {
  let component: AwaiComponent;
  let fixture: ComponentFixture<AwaiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AwaiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AwaiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

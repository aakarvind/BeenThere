import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LootgayaComponent } from './lootgaya.component';

describe('LootgayaComponent', () => {
  let component: LootgayaComponent;
  let fixture: ComponentFixture<LootgayaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LootgayaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LootgayaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

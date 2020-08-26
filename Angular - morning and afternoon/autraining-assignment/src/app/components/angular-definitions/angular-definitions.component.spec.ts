import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularDefinitionsComponent } from './angular-definitions.component';

describe('AngularDefinitionsComponent', () => {
  let component: AngularDefinitionsComponent;
  let fixture: ComponentFixture<AngularDefinitionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularDefinitionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularDefinitionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

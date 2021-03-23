import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { HeaderComponent } from './header.component';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
  // choose any html tag that may be unique to your html page
  // make a variable out of it.
  let h4: HTMLElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HeaderComponent],
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
      ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    h4=fixture.nativeElement.querySelector('h4');
  });
  // // use fixture.changes() if you need to detect changes after reload.
  it('should contain correct title after changes', () => {
    fixture.detectChanges();
    expect(h4.textContent).toEqual(`Hello ${component.userName} !`)
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
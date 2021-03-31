import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStudent} from '../models/istudent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  @Input() student;

  hidden = false;
  @Output()
  changedHidden: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor() {
  }

  ngOnInit(): void {
  }

  hiddenStudent() {
    this.hidden = !this.hidden;
    this.changedHidden.emit(this.hidden);
  }

}

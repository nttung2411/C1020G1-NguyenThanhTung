import {Component, Input, OnInit} from '@angular/core';
import {IStudent} from '../models/istudent';
import {studentList} from './studentlist';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  student: IStudent;
  check;
  constructor() {
  }

  students = studentList;

  ngOnInit(): void {
  }

  idStudent(student: IStudent){
    this.student = student;
    this.check = false;
  }

  change(checked: boolean){
    this.check = checked;
  }
}

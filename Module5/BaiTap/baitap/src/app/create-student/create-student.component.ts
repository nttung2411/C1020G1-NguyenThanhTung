import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {studentList} from '../student-list/studentlist';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {

  formCreate = new FormGroup({
    id : new FormControl('', [Validators.required]),
    name : new FormControl(),
    age : new FormControl('',[]),
    mark : new FormControl(),
  });

  constructor() { }

  ngOnInit(): void {
  }

  createStudent(){
    studentList.push(this.formCreate.value);
  }
}

import {Component, OnInit} from '@angular/core';
import {IStudent} from '../models/istudent';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {

  student: IStudent = {
    id: 1,
    name: 'Nguyễn Việt Dũng',
    age: 18,
    mark: 7,
    avatar: 'https://scontent.fsgn2-1.fna.fbcdn.net/v/t1.0-9/107095282_3066778733441520_5322713994353487325_o.jpg?_nc_cat=105&ccb=1-3&_nc_sid=09cbfe&_nc_ohc=mCSIJDUV_TMAX-YFh7s&_nc_ht=scontent.fsgn2-1.fna&oh=dcdcbefc51a4ed44d56ceda0cdc71611&oe=6088CA8A'
  };

  constructor() {
  }

  ngOnInit(): void {
  }

}

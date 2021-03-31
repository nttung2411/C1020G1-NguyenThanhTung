import {Component, Input, OnInit, Output, EventEmitter, SimpleChanges, OnChanges} from '@angular/core';

interface IRatingUnit {
  value: number;
  active: boolean;
}

@Component({
  selector: 'app-ratingbar',
  templateUrl: './ratingbar.component.html',
  styleUrls: ['./ratingbar.component.scss']
})
export class RatingbarComponent implements OnInit, OnChanges {

  @Input()
  max = 5;
  @Input()
  ratingValue = 5;
  @Input()
  showRatingValue = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingUnits: Array<IRatingUnit> = [];

  constructor() {
  }

  // tslint:disable-next-line:typedef
  ngOnChanges(changes: SimpleChanges) {
    if ('max' in changes) {
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 5 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  // tslint:disable-next-line:typedef
  calculate(max: number, ratingValue: number) {
    this.ratingUnits = Array.from({length: max},
      (_, index) => ({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  // tslint:disable-next-line:typedef
  select(index: number) {
    this.ratingValue = index + 1;
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }

  // tslint:disable-next-line:typedef
  enter(index: number) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= index);
  }

  // tslint:disable-next-line:typedef
  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }

}

import {Component, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-countdown-time-event-alias',
  templateUrl: './countdown-time-event-alias.component.html',
  styleUrls: ['./countdown-time-event-alias.component.css']
})
export class CountdownTimeEventAliasComponent implements OnInit , OnChanges , OnDestroy{

  private intervalId = 0;
  message = '';
  remainingTime: number | undefined;

  @Input()
  seconds = 11;

  // tslint:disable-next-line:no-output-rename
  @Output('timerEnd')
  finish = new EventEmitter<boolean>();

  // tslint:disable-next-line:typedef use-lifecycle-interface
  ngOnChanges(changes: SimpleChanges) {
    if ('seconds' in changes) {
      let v = changes.seconds.currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      this.seconds = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }

  // tslint:disable-next-line:typedef
  clearTimer() {
    clearInterval(this.intervalId);
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.reset();
    this.start();
  }

  // tslint:disable-next-line:typedef use-lifecycle-interface
  ngOnDestroy() {
    this.clearTimer();
  }

  // tslint:disable-next-line:typedef
  start() {
    this.countDown();
    // @ts-ignore
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  // tslint:disable-next-line:typedef
  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }

  // tslint:disable-next-line:typedef
  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
  }

  // tslint:disable-next-line:typedef
  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      // @ts-ignore
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.message = 'Blast off!';
        this.clearTimer();
        this.finish.emit(true);
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }

}
import {Component, Input, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown-time',
  templateUrl: './countdown-time.component.html',
  styleUrls: ['./countdown-time.component.css']
})
export class CountdownTimeComponent implements OnInit , OnDestroy{

  private intervalId = 0;
  message = '';
  remainingTime: number | undefined;

  @Input()
  seconds = 11;

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
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }

}

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-component-template';
  countdownMsg = '';
  countdownAliasMsg = '';
  // tslint:disable-next-line:typedef
  finishCountdown() {
    this.countdownMsg = 'Finished!';
  }

  // tslint:disable-next-line:typedef
  endCountdown() {
    this.countdownAliasMsg = 'Ended!';
  }

  // tslint:disable-next-line:typedef
  onRateChange(value: any) {
    console.log(value);
  }
}

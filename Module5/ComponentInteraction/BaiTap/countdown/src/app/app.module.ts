import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CountdownTimeAliasComponent } from './countdown-time-alias/countdown-time-alias.component';
import { CountdownTimeEventAliasComponent } from './countdown-time-event-alias/countdown-time-event-alias.component';
import { CountdownTimeEventComponent } from './countdown-time-event/countdown-time-event.component';
import { CountdownTimeGetSetComponent } from './countdown-time-get-set/countdown-time-get-set.component';
import { CountdownTimeOnchangesComponent } from './countdown-time-onchanges/countdown-time-onchanges.component';
import { CountdownTimeComponent } from './countdown-time/countdown-time.component';
import { RatingbarComponent } from './ratingbar/ratingbar.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimeAliasComponent,
    CountdownTimeEventAliasComponent,
    CountdownTimeEventComponent,
    CountdownTimeGetSetComponent,
    CountdownTimeOnchangesComponent,
    CountdownTimeComponent,
    RatingbarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

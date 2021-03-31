import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  articles;
  art;

  listArticle(array: Array<any>) {
    this.articles = array;
  }

  sendLikes(art: any) {
    this.art = art;
    this.art.likes++;
  }
}

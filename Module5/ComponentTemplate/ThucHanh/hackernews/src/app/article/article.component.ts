import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {articles} from './article';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  articleList = articles;
  @Output()
  listArticle: EventEmitter<Array<any>> = new EventEmitter<Array<any>>();

  addArticle(newTittle, newUrl) {
    this.articleList.push({title: newTittle.value, url: newUrl.value, likes: 0});
    this.listArticle.emit(this.articleList);
  }

  constructor() {
  }

  ngOnInit(): void {
    this.listArticle.emit(this.articleList);
  }

}

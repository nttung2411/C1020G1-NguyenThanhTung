import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormControl} from '@angular/forms';

interface ITodo {
  id: number;
  content: string;
  complete: boolean;
}

// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnChanges {
  userInput = new FormControl();
  todos: Array<ITodo> = [];

  constructor() {
  }

  // tslint:disable-next-line:typedef
  ngOnInit() {
  }

  // tslint:disable-next-line:typedef
  onChange() {
    const {value} = this.userInput;
    if (value) {
      const todo: ITodo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.userInput.setValue('');
    }
  }

  // tslint:disable-next-line:typedef
  toggleTodo(i: string | number) {
    // @ts-ignore
    this.todos[i].complete = !this.todos[i].complete;
  }

  ngOnChanges(changes: SimpleChanges): void {
  }
}

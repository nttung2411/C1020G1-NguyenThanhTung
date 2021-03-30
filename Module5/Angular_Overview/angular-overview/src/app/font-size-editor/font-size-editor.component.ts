import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-font-size-editor',
  templateUrl: './font-size-editor.component.html',
  styleUrls: ['./font-size-editor.component.scss']
})
export class FontSizeEditorComponent implements OnInit {
  fontsize = 14;
  constructor() { }

  onchange(value){
    this.fontsize = value;
  }

  ngOnInit(): void {
  }

}

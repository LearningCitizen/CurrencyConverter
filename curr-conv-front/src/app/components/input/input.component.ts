import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {

  @Input() name: string = "input";
  @Output() valueEmitter: EventEmitter<number> = new EventEmitter<number>();
  value: number=1;

  
  constructor() { }

  ngOnInit(): void {
  }

  emitValue(){
    this.valueEmitter.emit(this.value);
  }

}

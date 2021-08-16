import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { Currency } from '../../model/currency';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  @Input() name: string = "select";
  value: string = "value";
  @Output() valueEmitter: EventEmitter<string> = new EventEmitter<string>();
  currencies : Currency[] = [];
  cur : any;

  constructor(private currencyService: CurrencyService) { }

  ngOnInit(): void {
    this.currencyService.getCurrenciesList().subscribe((curr) => 
    {
      this.currencies = curr;
      this.value=this.currencies[0].trigram;
      this.emitValue();
    });
  }

  emitValue(){
    this.valueEmitter.emit(this.value);
  }

}

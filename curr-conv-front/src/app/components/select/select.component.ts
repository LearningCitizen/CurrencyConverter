import { Component, OnInit, Input } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { Currency } from '../../model/currency';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  @Input() name: string = "select";
  currencies : Currency[] = [];
  cur : any;

  constructor(private currencyService: CurrencyService) { }

  ngOnInit(): void {
    this.currencyService.getCurrenciesList().subscribe((curr) => {this.currencies = curr;console.log(`currs : ${this.currencies} curr: ${curr}`)});

  }

  size(){
    return 0;
  }

}

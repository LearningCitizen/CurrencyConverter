import { Component, OnInit } from '@angular/core';
import { Currency } from 'src/app/model/currency';
import { CurrencyService } from 'src/app/services/currency.service';

@Component({
  selector: 'app-currencies',
  templateUrl: './currencies.component.html',
  styleUrls: ['./currencies.component.css']
})
export class CurrenciesComponent implements OnInit {

  currencies: Currency[] = [];

  constructor(private currencyService: CurrencyService) { }

  ngOnInit(): void {
    this.currencyService.getCurrenciesList().subscribe(currs => {this.currencies=currs;})
  }

}

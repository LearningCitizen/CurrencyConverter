import { Component, OnInit } from '@angular/core';
import { CurrencyService } from 'src/app/services/currency.service';

@Component({
  selector: 'app-conversion',
  templateUrl: './conversion.component.html',
  styleUrls: ['./conversion.component.css']
})
export class ConversionComponent implements OnInit {

  currencySource: string = "";
  currencyTarget: string = "";
  amount: number = 1;
  result:number = 0;
  displayResult : boolean = true

  constructor(private currencyService: CurrencyService) { }

  ngOnInit(): void {
  }

  getCurrencySource(currencySource:string){
    this.currencySource = currencySource;
    this.hideResult();
  }

  getCurrencyTarget(currencyTarget:string){
    this.currencyTarget = currencyTarget;
    this.hideResult();
  }

  getAmount(amount:number){
    this.amount = amount;
    this.hideResult();
  }

  convertCurrency(){
    this.currencyService.convertCurrency(this.currencySource, this.currencyTarget, this.amount)
    .subscribe(res => this.result = res);
    this.displayResult = false;
  }

  hideResult(){
    this.displayResult = true;
  }
}

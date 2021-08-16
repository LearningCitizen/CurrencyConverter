import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-conversion',
  templateUrl: './conversion.component.html',
  styleUrls: ['./conversion.component.css']
})
export class ConversionComponent implements OnInit {

  currencySource: string = "";
  currencyTarget: string = "";
  amount: number = 1;

  constructor() { }

  ngOnInit(): void {
  }

  getCurrencySource(currencySource:string){
    this.currencySource = currencySource;
  }

  getCurrencyTarget(currencyTarget:string){
    this.currencyTarget = currencyTarget;
  }

  getAmount(amount:number){
    this.amount = amount;
  }

  convertCurrency(){
    console.log(`source : ${this.currencySource} target : ${this.currencyTarget} amount : ${this.amount}`);
  }

}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Currency } from '../model/currency';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  private rootUrl:string = 'http://localhost:8080';
  private currenciesUri:string = '/api/v1/currencies';
  private conversionUri:string = '/api/v1/currencies/conversion';
  private result:number = 0;
  private displayResult : boolean = false;

  constructor(private httpClient: HttpClient) { }

  getCurrenciesList(): Observable<Currency[]> {
    return this.httpClient.get<Currency[]>(this.rootUrl + this.currenciesUri);
  }

  convertCurrency(currencySource:string, currencyTarget:string, amount:number): Observable<number> {
    return this.httpClient.get<number>(`${this.rootUrl}${this.conversionUri}`, {
      params: {
        amount: amount,
        source: currencySource,
        target: currencyTarget
      }});
  }

  clear(){

  }
}

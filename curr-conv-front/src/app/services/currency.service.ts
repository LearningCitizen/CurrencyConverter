import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Currency } from '../model/currency';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  private rootUrl:string = 'http://localhost:8080';
  private currenciesListEndPoint:string = '/api/v1/currencies';

  constructor(private httpClient: HttpClient) { }

  getCurrenciesList(): Observable<Currency[]> {
    return this.httpClient.get<Currency[]>(this.rootUrl + this.currenciesListEndPoint);
  }
}

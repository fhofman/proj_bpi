import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Price } from '../model/price';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class PriceService {

  private priceUrl: string;

  constructor(private http: HttpClient) {
    this.priceUrl = 'http://localhost:8080/prices2';
  }

  public findAll(): Observable<Price> {
    return this.http.get<Price>(this.priceUrl);
  }

  /*public save(user: Price) {
    return this.http.post<User>(this.usersUrl, user);
  }*/
}

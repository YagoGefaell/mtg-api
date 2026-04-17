import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ScryfallList } from '../models/scryfall-list';
import { Card } from '../models/card';

@Injectable({
  providedIn: 'root',
})
export class CardService {
  constructor(private http: HttpClient) {}

  getCards(): Observable<ScryfallList<Card>> {
    return this.http.get<ScryfallList<Card>>('http://localhost:8080/mtg/cards/all');
  }
}

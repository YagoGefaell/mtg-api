import { Component, OnInit } from '@angular/core';
import { CardService } from '../../services/card-service';
import { Card } from '../../models/card';
import { CommonModule } from '@angular/common';
import { CardItem } from '../card-item/card-item';

@Component({
  selector: 'app-card-grid',
  imports: [CommonModule, CardItem],
  templateUrl: './card-grid.html'
})
export class CardGrid implements OnInit {
  cards: Card[] = [];

  constructor(private cardService:CardService) {}

  ngOnInit(): void {
    this.cardService.getCards().subscribe({
      next: (response) => {
        this.cards = response.data;
      },
      error: (err) => console.error('Error de conexión: ', err)
    })
  }
}

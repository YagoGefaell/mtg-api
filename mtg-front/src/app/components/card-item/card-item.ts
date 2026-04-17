import { Component, Input } from '@angular/core';
import { Card } from '../../models/card';

@Component({
  selector: 'app-card-item',
  imports: [],
  templateUrl: './card-item.html',
})
export class CardItem {
  @Input() card!: Card;
}

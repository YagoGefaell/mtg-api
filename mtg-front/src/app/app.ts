import { Component } from '@angular/core';
import { CardGrid } from './components/card-grid/card-grid';

@Component({
  selector: 'app-root',
  imports: [CardGrid],
  templateUrl: './app.html'
})
export class App {}

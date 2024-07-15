import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pgras',
  standalone: true,
  imports: [],
  templateUrl: './pgras.component.html',
  styleUrl: './pgras.component.css',
})
export class PGrasComponent {
  @Input('message')
  texte!: string;
}

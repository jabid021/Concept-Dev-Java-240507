import { Component } from '@angular/core';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [],
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css',
})
export class ProduitComponent {
  nom = 'tele';
  prix = 1000;
}

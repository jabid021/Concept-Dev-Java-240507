import { Component } from '@angular/core';
import { Produit } from '../../../model/produit';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css',
})
export class ProduitComponent {
  produits: Produit[] = [
    new Produit('tele', 1000),
    new Produit('telephone', 500),
    { nom: 'avion', prix: 999999999 },
  ];
}

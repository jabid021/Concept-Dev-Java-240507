import { Component, Input } from '@angular/core';
import { Produit } from '../../../../model/produit';

@Component({
  selector: 'app-display-produit',
  standalone: true,
  imports: [],
  templateUrl: './display-produit.component.html',
  styleUrl: './display-produit.component.css'
})
export class DisplayProduitComponent {
  @Input()
  produit!:Produit;
}

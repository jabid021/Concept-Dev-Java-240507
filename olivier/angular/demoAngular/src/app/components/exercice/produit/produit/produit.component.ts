import { Component, OnInit } from '@angular/core';
import { Produit } from '../../../../model/produit';
import { FormsModule } from '@angular/forms';
import { DisplayProduitComponent } from '../display-produit/display-produit.component';
import { FormProduitComponent } from '../form-produit/form-produit.component';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [FormsModule, DisplayProduitComponent, FormProduitComponent],
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css',
})
export class ProduitComponent implements OnInit {
  ngOnInit(): void {}

  produitAAfficher!: Produit;

  recuperationDuProduitDepuisLEvenement(produitRecuDeLEvenement: Produit) {
    this.produitAAfficher = new Produit(
      produitRecuDeLEvenement.nom,
      produitRecuDeLEvenement.prix,
      produitRecuDeLEvenement.image
    );
  }
}

import { Component, OnInit } from '@angular/core';
import { Produit } from '../../../../model/produit';
import { FormsModule } from '@angular/forms';
import { DisplayProduitComponent } from '../display-produit/display-produit.component';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [FormsModule, DisplayProduitComponent],
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css',
})
export class ProduitComponent implements OnInit {
  ngOnInit(): void {
    this.produit = new Produit();
  }
  message = '';
  produit!: Produit;
  produitAAfficher!: Produit;

  valider() {
    if (this.produit.nom && this.produit.prix) {
      //produit complet
      this.produitAAfficher = new Produit(
        this.produit.nom,
        this.produit.prix,
        this.produit.image
      );
    } else {
      this.message = 'il manque des infos';
    }
  }
}

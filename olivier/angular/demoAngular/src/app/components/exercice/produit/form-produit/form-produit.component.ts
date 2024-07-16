import { Component, EventEmitter, Output } from '@angular/core';
import { Produit } from '../../../../model/produit';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-produit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form-produit.component.html',
  styleUrl: './form-produit.component.css',
})
export class FormProduitComponent {
  produit: Produit = new Produit();

  //on definit un evenement produitReadyEvent
  //on trouvera dans levenement un produit quand il sera declenché
  @Output()
  produitReadyEvent = new EventEmitter<Produit>();
  message = '';

  @Output()
  jsonReadyEvent = new EventEmitter<any>();

  validerQuiEnvoieDuJSon() {
    if (this.produit.nom && this.produit.prix) {
      this.message = '';
      this.produitReadyEvent.emit({
        nom: this.produit.nom,
        prix: this.produit.prix,
        image: this.produit.image,
      });
    } else {
      this.message = 'invalide';
    }
  }

  valider() {
    //fait sortir le produit du component
    if (this.produit.nom && this.produit.prix) {
      this.message = '';
      this.produitReadyEvent.emit(this.produit);
    } else {
      this.message = 'invalide';
    }
  }
}

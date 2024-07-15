import { Component } from '@angular/core';
import { Personne } from '../../../model/personne';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-personne',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './personne.component.html',
  styleUrl: './personne.component.css',
})
export class PersonneComponent {
  personne: Personne = new Personne();

  message = '';

  ok() {
    if (this.personne.nom && this.personne.prenom) {
      this.message = this.personne.infos;
    } else {
      this.message = 'il manque des infos';
    }
  }
}

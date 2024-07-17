import { Component } from '@angular/core';
import { Produit } from '../../../model/produit';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { DemoService } from '../../../services/demo.service';

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

  constructor(private demoSrv: DemoService) {
    console.log(this.demoSrv.hello());
  }
}

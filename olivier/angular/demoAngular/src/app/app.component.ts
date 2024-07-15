import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DemoComponent } from "./components/demo/demo.component";
import { ProduitComponent } from "./components/exercice/produit/produit/produit.component";
import { PersonneComponent } from "./components/exercice/personne/personne.component";
import { PGrasComponent } from "./components/pgras/pgras.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, DemoComponent, ProduitComponent, PersonneComponent, PGrasComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'demoAngular';
}

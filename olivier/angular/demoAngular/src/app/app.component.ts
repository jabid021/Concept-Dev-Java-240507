import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { DemoComponent } from './components/demo/demo.component';
import { ProduitComponent } from './components/exercice/produit/produit/produit.component';
import { PersonneComponent } from './components/exercice/personne/personne.component';
import { PGrasComponent } from './components/pgras/pgras.component';
import { EquipeComponent } from './components/exercice/sondage/equipe/equipe.component';
import { SondageComponent } from './components/exercice/sondage/sondage/sondage.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    DemoComponent,
    ProduitComponent,
    PersonneComponent,
    PGrasComponent,
    EquipeComponent,
    SondageComponent,
    RouterLink,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'demoAngular';
}

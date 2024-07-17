import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { DetailComponent } from './components/produit/detail/detail.component';
import { FiliereComponent } from './components/filiere/filiere/filiere.component';
import { EditFiliereComponent } from './components/filiere/edit-filiere/edit-filiere.component';
import { StagiaireComponent } from './components/stagiaire/stagiaire/stagiaire.component';
import { StagiaireEditComponent } from './components/stagiaire/stagiaire-edit/stagiaire-edit.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produit', component: ProduitComponent },
  { path: 'produit/:nom', component: DetailComponent },
  { path: 'filiere', component: FiliereComponent },
  { path: 'filiere/edit', component: EditFiliereComponent },
  { path: 'filiere/edit/:id', component: EditFiliereComponent },
  { path: 'stagiaire', component: StagiaireComponent },
  { path: 'stagiaire/edit', component: StagiaireEditComponent },
  { path: 'stagiaire/edit/:id', component: StagiaireEditComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

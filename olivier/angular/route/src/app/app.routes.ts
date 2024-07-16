import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { DetailComponent } from './components/produit/detail/detail.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produit', component: ProduitComponent },
  { path: 'produit/:nom', component: DetailComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

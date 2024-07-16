import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { SondageComponent } from './components/exercice/sondage/sondage/sondage.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { ProduitComponent } from './components/exercice/produit/produit/produit.component';
import { ParamComponent } from './components/param/param.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'sondage', component: SondageComponent },
  { path: 'exercice/produit', component: ProduitComponent },
  { path: 'param/:id', component: ParamComponent },
  { path: 'sidebar', component: SidebarComponent, outlet: 'sidebar' },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

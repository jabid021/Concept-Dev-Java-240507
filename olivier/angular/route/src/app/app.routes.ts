import { AuthGuardService } from './services/auth-guard.service';
import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProduitComponent } from './components/produit/produit/produit.component';
import { DetailComponent } from './components/produit/detail/detail.component';
import { FiliereComponent } from './components/filiere/filiere/filiere.component';
import { EditFiliereComponent } from './components/filiere/edit-filiere/edit-filiere.component';
import { StagiaireComponent } from './components/stagiaire/stagiaire/stagiaire.component';
import { StagiaireEditComponent } from './components/stagiaire/stagiaire-edit/stagiaire-edit.component';
import { LoginComponent } from './components/login/login.component';
import { authGuard } from './guards/auth.guard';
import { anonymousGuard } from './guards/anonymous.guard';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'produit',
    component: ProduitComponent,
  },
  { path: 'produit/:nom', component: DetailComponent },
  { path: 'filiere', component: FiliereComponent, canActivate: [authGuard] },
  {
    path: 'filiere/edit',
    component: EditFiliereComponent,
    canActivate: [authGuard],
  },
  {
    path: 'filiere/edit/:id',
    component: EditFiliereComponent,
    canActivate: [authGuard],
  },
  {
    path: 'stagiaire',
    component: StagiaireComponent,
    canActivate: [authGuard],
  },
  {
    path: 'stagiaire/edit',
    component: StagiaireEditComponent,
    canActivate: [authGuard],
  },
  {
    path: 'stagiaire/edit/:id',
    component: StagiaireEditComponent,
    canActivate: [authGuard],
  },
  { path: 'login', component: LoginComponent, canActivate: [anonymousGuard] },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

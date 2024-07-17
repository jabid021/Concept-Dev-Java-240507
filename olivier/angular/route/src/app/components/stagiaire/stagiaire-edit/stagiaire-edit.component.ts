import { StagiaireService } from './../../../services/stagiaire.service';
import { Component, OnInit } from '@angular/core';
import { Stagiaire } from '../../../model/stagiaire';
import { FormsModule } from '@angular/forms';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';
import { FiliereService } from '../../../services/filiere.service';
import { Filiere } from '../../../model/filiere';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-stagiaire-edit',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive, AsyncPipe],
  templateUrl: './stagiaire-edit.component.html',
  styleUrl: './stagiaire-edit.component.css',
})
export class StagiaireEditComponent implements OnInit {
  stagiaire: Stagiaire = new Stagiaire();

  // filieres: Filiere[] = [];
  filieresObservable!: Observable<Filiere[]>;

  constructor(
    public filiereSrv: FiliereService,
    private router: Router,
    public stagiaireSrv: StagiaireService,
    public activatedroute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // this.filiereSrv.getAll().subscribe((filieres) => {
    //   this.filieres = filieres;
    // });
    this.filieresObservable = this.filiereSrv.getAll();
    this.activatedroute.params.subscribe((params) => {
      if (params['id']) {
        this.stagiaireSrv.getById(params['id']).subscribe((stagiaire) => {
          this.stagiaire = stagiaire;
        });
      }
    });
  }

  save() {
    if (this.stagiaire.id) {
      this.stagiaireSrv.update(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=update&id=' + stagiaire.id);
      });
    } else {
      this.stagiaireSrv.create(this.stagiaire).subscribe((stagiaire) => {
        this.router.navigateByUrl('/stagiaire?q=create&id=' + stagiaire.id);
      });
    }
  }

  compareFn(f1: Filiere, f2: Filiere): boolean {
    //return f1 && f2 ? f1.id === f2.id : false;
    if (f1 && f2) {
      return f1.id === f2.id;
    } else {
      return false;
    }
  }
}

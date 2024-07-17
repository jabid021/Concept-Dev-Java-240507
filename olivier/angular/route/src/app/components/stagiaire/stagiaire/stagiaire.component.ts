import { Component, OnInit } from '@angular/core';
import { StagiaireService } from '../../../services/stagiaire.service';
import { Stagiaire } from '../../../model/stagiaire';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-stagiaire',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './stagiaire.component.html',
  styleUrl: './stagiaire.component.css',
})
export class StagiaireComponent implements OnInit {
  stagiaires: Stagiaire[] = [];

  constructor(public stagiaireSrv: StagiaireService) {}
  ngOnInit(): void {
    this.initStagiaires();
  }

  initStagiaires() {
    this.stagiaireSrv.getAll().subscribe((stagiaires) => {
      this.stagiaires = stagiaires;
    });
  }

  delete(id: number) {
    this.stagiaireSrv.delete(id).subscribe(() => {
      this.initStagiaires();
    });
  }
}

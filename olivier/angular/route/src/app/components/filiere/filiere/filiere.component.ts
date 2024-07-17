import { Component } from '@angular/core';
import { FiliereService } from '../../../services/filiere.service';
import { Filiere } from '../../../model/filiere';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-filiere',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './filiere.component.html',
  styleUrl: './filiere.component.css',
})
export class FiliereComponent {
  filieres: Filiere[] = [];

  constructor(private filiereSrv: FiliereService) {
    this.initFiliere();
  }
  delete(id: number) {
    this.filiereSrv.delete(id).subscribe(() => {
      this.initFiliere();
    });
  }

  initFiliere() {
    this.filiereSrv.getAll().subscribe((filieres) => {
      this.filieres = filieres;
    });
  }
}

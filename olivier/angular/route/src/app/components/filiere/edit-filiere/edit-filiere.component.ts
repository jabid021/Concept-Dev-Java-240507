import { Component } from '@angular/core';
import { Filiere } from '../../../model/filiere';
import { FormsModule } from '@angular/forms';
import { FiliereService } from '../../../services/filiere.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-filiere',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-filiere.component.html',
  styleUrl: './edit-filiere.component.css',
})
export class EditFiliereComponent {
  filiere: Filiere = new Filiere();

  constructor(private filiereSrv: FiliereService, private router: Router) {}
  save() {
    this.filiereSrv.create(this.filiere).subscribe((filiere) => {
      this.router.navigateByUrl('/filiere');
    });
  }
}

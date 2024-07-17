import { Component, OnInit } from '@angular/core';
import { Filiere } from '../../../model/filiere';
import { FormsModule } from '@angular/forms';
import { FiliereService } from '../../../services/filiere.service';
import {
  ActivatedRoute,
  Router,
  RouterLink,
  RouterLinkActive,
} from '@angular/router';

@Component({
  selector: 'app-edit-filiere',
  standalone: true,
  imports: [FormsModule, RouterLink, RouterLinkActive],
  templateUrl: './edit-filiere.component.html',
  styleUrl: './edit-filiere.component.css',
})
export class EditFiliereComponent implements OnInit {
  filiere: Filiere = new Filiere();

  constructor(
    private filiereSrv: FiliereService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.filiereSrv.getById(params['id']).subscribe((filiere) => {
          this.filiere = filiere;
        });
      }
    });
  }

  save() {
    if (this.filiere.id) {
      this.filiereSrv.update(this.filiere).subscribe((filiere) => {
        this.router.navigateByUrl('/filiere');
      });
    } else {
      this.filiereSrv.create(this.filiere).subscribe((filiere) => {
        this.router.navigateByUrl('/filiere');
      });
    }
  }
}

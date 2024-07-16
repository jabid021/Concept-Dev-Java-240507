import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-param',
  standalone: true,
  imports: [],
  templateUrl: './param.component.html',
  styleUrl: './param.component.css',
})
export class ParamComponent implements OnInit {
  nom!: string;
  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    // this.nom=this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.params.subscribe((params) => {
      setTimeout(() => {
        this.nom = params['id'];
      }, 1000);
    });
    console.log(this.nom);
  }

  
}

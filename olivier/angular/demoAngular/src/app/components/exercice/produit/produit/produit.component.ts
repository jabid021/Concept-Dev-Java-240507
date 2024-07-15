import { Component, OnInit } from '@angular/core';
import { Produit } from '../../../../model/produit';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-produit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './produit.component.html',
  styleUrl: './produit.component.css',
})
export class ProduitComponent implements OnInit {
  ngOnInit(): void {
    this.produit = new Produit(
      'teleeeee',
      1000,
      'https://cdn.pixabay.com/photo/2016/11/21/12/10/tv-1844964_1280.jpg'
    );
  }

  produit!: Produit;
  message = '';

  hello() {
    console.log('hello world');
    this.message = 'toto';
  }
}

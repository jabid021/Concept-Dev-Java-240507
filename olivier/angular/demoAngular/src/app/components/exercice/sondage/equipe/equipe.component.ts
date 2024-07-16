import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Equipe } from '../../../../model/equipe';

@Component({
  selector: 'app-equipe',
  standalone: true,
  imports: [],
  templateUrl: './equipe.component.html',
  styleUrl: './equipe.component.css',
})
export class EquipeComponent implements OnInit {
  ngOnInit(): void {
    this.equipe = new Equipe(this.pays, this.drapeau);
  }

  equipe!: Equipe;
  @Input()
  pays!: string;
  @Input()
  drapeau!: string;

  @Output()
  voteEvent: EventEmitter<any> = new EventEmitter();

  vote = 0;

  voter() {
    this.vote++;
    this.voteEvent.emit({
      equipe: this.equipe,
      vote: this.vote,
    });
  }
}

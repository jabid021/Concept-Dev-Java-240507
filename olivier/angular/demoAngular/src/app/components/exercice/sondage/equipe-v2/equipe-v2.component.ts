import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Equipe } from '../../../../model/equipe';

@Component({
  selector: 'app-equipe-v2',
  standalone: true,
  imports: [],
  templateUrl: './equipe-v2.component.html',
  styleUrl: './equipe-v2.component.css',
})
export class EquipeV2Component {
  @Input()
  equipe!: Equipe;
  vote = 0;

  @Output()
  voteEvent: EventEmitter<any> = new EventEmitter();

  voter() {
    this.vote++;
    this.voteEvent.emit({
      equipe: this.equipe,
      vote: this.vote,
    });
  }
}

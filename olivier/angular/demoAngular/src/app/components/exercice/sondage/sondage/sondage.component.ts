import { Component } from '@angular/core';
import { EquipeComponent } from '../equipe/equipe.component';
import { EquipeV2Component } from '../equipe-v2/equipe-v2.component';
import { Equipe } from '../../../../model/equipe';

@Component({
  selector: 'app-sondage',
  standalone: true,
  imports: [EquipeComponent, EquipeV2Component],
  templateUrl: './sondage.component.html',
  styleUrl: './sondage.component.css',
})
export class SondageComponent {
  message = 'meilleur equipe de ping pong';
  equipes: Equipe[] = [
    new Equipe(
      'france',
      'https://cdn-icons-png.flaticon.com/128/197/197560.png'
    ),
    new Equipe(
      'suisse',
      'https://cdn-icons-png.flaticon.com/128/197/197540.png'
    ),
    new Equipe(
      'coree',
      'https://cdn-icons-png.flaticon.com/128/197/197582.png'
    ),
    new Equipe(
      'france',
      'https://cdn-icons-png.flaticon.com/128/197/197560.png'
    ),
  ];
  voteEquipeEnTete = 0;

  traitementVote(data: any) {
    console.log(data);
    if (data.vote > this.voteEquipeEnTete) {
      this.voteEquipeEnTete = data.vote;
      this.message = `Meilleur equipe:${data.equipe.nom} avec ${data.vote} votes`;
    }
  }
}

import { Filiere } from './filiere';

export class Stagiaire {
  constructor(
    public id?: number,
    public prenom?: string,
    public nom?: string,
    public email?: string,
    public filiere?: Filiere
  ) {}
}

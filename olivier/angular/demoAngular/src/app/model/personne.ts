export class Personne {
  constructor(public prenom?: string, public nom?: string) {}

  public get infos(): string {
    return `${this.prenom} ${this.nom}`;
  }
}

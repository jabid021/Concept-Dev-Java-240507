export class Produit {
  // public get prix(): number {
  //   return this._prix;
  // }
  // public set prix(value: number) {
  //   this._prix = value;
  // }
  // // private nom: string;
  // // private prix: number;

  // // constructor(nom: string, prix: number) {
  // //   this.nom = nom;
  // //   this.prix = prix;
  // //}

  // constructor(private _nom: string, private _prix: number) {}

  // get nom(): string {
  //   return this._nom;
  // }

  // set nom(value: string) {
  //   this._nom = value;
  // }

  constructor(public nom?: string, public prix?: number,public image?:string) {}
}

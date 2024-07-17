import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {
    console.log('construction du service');
  }

  public hello(): string {
    return 'hello du service';
  }
}

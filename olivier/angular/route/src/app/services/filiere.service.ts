import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filiere } from '../model/filiere';

@Injectable({
  providedIn: 'root',
})
export class FiliereService {
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Filiere[]> {
    return this.httpClient.get<Filiere[]>(
      'http://localhost:8080/demo/api/filiere'
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      'http://localhost:8080/demo/api/filiere/' + id
    );
  }
}

import { Filiere } from './../model/filiere';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FiliereService {
  url = 'http://localhost:8080/demo/api/filiere';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Filiere[]> {
    return this.httpClient.get<Filiere[]>(this.url);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }

  public create(filiere: Filiere): Observable<Filiere> {
    return this.httpClient.post<Filiere>(this.url, filiere);
  }

  public getById(id: number): Observable<Filiere> {
    return this.httpClient.get<Filiere>(`${this.url}/${id}`);
  }

  public update(filiere: Filiere): Observable<Filiere> {
    return this.httpClient.put<Filiere>(`${this.url}/${filiere.id}`, filiere);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

import {Registrazione, UtenteCompleto} from '../model/utente';

@Injectable({
  providedIn: 'root'
})
export class UtenteServiceService {
  private backendUrl = "http://localhost:8080"

  isUser:boolean = false
  type:number = 0


  constructor(private http:HttpClient,private auth:AuthServiceService, private router: Router) {  }

  // @ts-ignore
  checkUtente(username: string): Observable<boolean> {
    const url = `${this.backendUrl}/checkUtente/${username}`;

    return this.http.get<boolean>(url);
  }

  getTipo(username: string): Observable<number> {
    const url = `${this.backendUrl}/getTipo/${username}`;
    const headers = new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token);

    return this.http.get<number>(url, { headers });
  }

  registraUtente(username: string, password: string, tipo: number, nome: string, cognome: string, data: string, via: string, civico: number, email: string) {


    // Creazione dell'header con il token di autorizzazione
    const headers = new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token);

    // Invio della richiesta POST al backend
    return this.http.post(this.backendUrl + "/registrazione/"+username+"/"+password+"/"+tipo+"/"+nome+"/"+cognome+"/"+data+"/"+via+"/"+civico+"/"+email , headers );
  }

  getAllUtente() {
    const headers = new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token);
    return this.http.get<UtenteCompleto[]>(this.backendUrl + "/getAllUtente", { headers });


  }

  changeTipo(username: string, number: number) {
    const headers = new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token);
    return this.http.get<boolean>(this.backendUrl + "/changeTipo/"+username+"/"+number, { headers });


  }
}

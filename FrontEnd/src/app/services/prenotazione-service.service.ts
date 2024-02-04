import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneServiceService {
  backendUrl = "http://localhost:8080"

  constructor(private http:HttpClient,private auth:AuthServiceService) { }

  prenota(nome: string, cognome: string, email: string, telefono: string, data: string, commenti: string) {
    const headers = new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token);
    return this.http.post(this.backendUrl + "/prenota/"+nome+"/"+cognome+"/"+email+"/"+telefono+"/"+data+"/"+commenti, { headers });
  }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";
import {Prenotazione} from "../model/prenotazione";
import {Segnalazione} from "../model/segnalazioni";

@Injectable({
  providedIn: 'root'
})
export class PrenotazioneServiceService {
  backendUrl = "http://localhost:8080"

  constructor(private http:HttpClient,private auth:AuthServiceService) { }

  prendiDate(){

    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }

    return this.http.get<string[]>(this.backendUrl+"/prenotazioni/date", header);
  }

  mettiPrenotazioneTavola(value1: any, value2: any, value3: any, value4: any, value5: any, value: any){
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    this.http.post(this.backendUrl + "/prenotazioni/tavola/" + value1 + "/" + value2 + "/" + value3 + "/" + value4 + "/" + value5 + "/" + value, null, header).subscribe(
      data => {
        console.log("POST Request is successful ", data);
      },
      error => {
        console.log("Error", error);
      }
    )

  }

  getAllPrenotazione() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    return this.http.get<Prenotazione[]>(this.backendUrl + "/prenotazioni/tutte", header);

  }

  accettaPrenotazione(id: number) {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    return this.http.post(this.backendUrl + "/prenotazioni/accetta/" + id, header);


  }

  rifiutaPrenotazione(id: number) {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.post(this.backendUrl + "/prenotazioni/rifiuta/" + id, header);}

  getAllPrenotazioneUtente() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Prenotazione[]>(this.backendUrl + "/prenotazioni/utente", header);

  }

  getAllSegnalazioni() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Segnalazione[]>(this.backendUrl + "/segnalazioni/get", header);

  }
}

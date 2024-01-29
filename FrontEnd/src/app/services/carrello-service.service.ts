import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";
import {Piatto} from "../model/piatto";
import {Carrello} from "../model/carrello";

@Injectable({
  providedIn: 'root'
})
export class CarrelloServiceService {
  private backendUrl = "http://localhost:8080"


  constructor(private http:HttpClient,private auth:AuthServiceService) { }

  addPiatto(piatto: Piatto | undefined) {
    console.log("STAMPO PIATTO " + piatto?.nome)
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return  this.http.get<boolean>(this.backendUrl +"/pushCarrello/"+piatto?.nome + "/" + piatto?.prezzo+ "/" + this.auth.token,  header )

  }

  getCarrello(){

    console.log("STAMPO TOKEN " + this.auth.token)
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Carrello[]>(this.backendUrl +"/getCarrello/"+ this.auth.token,  header )
  }

  deletePiatto(piatto: Piatto | undefined) {    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)

    }
    return  this.http.get<boolean>(this.backendUrl +"/deleteCarrello/"+piatto?.nome + "/" + this.auth.token,  header )

  }
}

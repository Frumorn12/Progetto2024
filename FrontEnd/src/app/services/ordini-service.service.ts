import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";
import {Ordine} from "../model/ordine";

@Injectable({
  providedIn: 'root'
})
export class OrdiniServiceService {


  private backendUrl = "http://localhost:8080"

  constructor(private http:HttpClient,private auth:AuthServiceService) { }


  getOrdini() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    return this.http.get<Ordine[]>(this.backendUrl + "/ordini",header)

  }
}

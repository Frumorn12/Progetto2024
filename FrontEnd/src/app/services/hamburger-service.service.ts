import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./auth-service.service";
import {Ingrediente} from "../model/ingrediente";
import {Hamburger} from "../model/hamburger";
import {Immagini} from "../model/immagini";

@Injectable({
  providedIn: 'root'
})
export class HamburgerServiceService {
  private backendUrl = "http://localhost:8080"

  constructor(private http:HttpClient,private auth:AuthServiceService) { }

  dammiBase(){
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    return this.http.get<Ingrediente[]>(this.backendUrl + "/base",header)

  }

  dammiIngredienti(){
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }
    return this.http.get<Ingrediente[]>(this.backendUrl + "/ingredienti",header)

  }

  dammiSalsa(){
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)}
    return this.http.get<Ingrediente[]>(this.backendUrl + "/salsa",header)


  }

  dammiCarne(){
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)}
    return this.http.get<Ingrediente[]>(this.backendUrl + "/carne",header)}


  addIngrediente(ingrediente: Ingrediente | undefined) {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' +  this.auth.token)
    }
    return  this.http.get<boolean>(this.backendUrl +"/addIngrediente/"+ingrediente?.nome + "/" + ingrediente?.prezzo+ "/" + this.auth.token,  header )

  }

  getHamburger() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' +  this.auth.token)
    }
    return this.http.get<Hamburger[]>(this.backendUrl + "/getHamburger",header)

  }

  dammiImmagini() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' +  this.auth.token)
    }
    return this.http.get<Immagini[]>(this.backendUrl + "/immagini",header)

  }
  dammiImmagine(nome: string | undefined) {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' +  this.auth.token)
    }
    return this.http.get<Immagini>(this.backendUrl + "/immagine/"+nome,header)}

  dammiContorno() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)}
    return this.http.get<Ingrediente[]>(this.backendUrl + "/contorno1",header)}


  dammiBevande() {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)}
    return this.http.get<Ingrediente[]>(this.backendUrl + "/bevande1",header)

  }


  deleteIngrediente(ingrediente: Ingrediente | undefined) {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)}
    return this.http.get<boolean>(this.backendUrl + "/deleteIngrediente/"+ingrediente?.nome,header)


  }
}

import {Injectable, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthServiceService} from "./services/auth-service.service";
import {Observable} from "rxjs";
import {Piatto} from "./model/piatto";
import {Recensione, RecensioneCompleta} from "./model/recensione";

@Injectable({
  providedIn: 'root'
})
export class PiattiServiceService {
  private backendUrl = "http://localhost:8080"



  constructor(private http:HttpClient,private auth:AuthServiceService) { }


  dammiAntipasti():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/antipasti",header)
  }

  dammiPrimi():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/primi",header)
  }

  dammiSecondi():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/secondi",header)
  }

  dammiContorni():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/contorni",header)
  }

  dammiDolci():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/dolci",header)
  }

  dammiSenzaLattosio():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/senzaLattosio",header)
  }

  dammiSenzaGlutine():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/senzaGlutine",header)
  }

  dammiBevande():Observable<Piatto[]>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto[]>(this.backendUrl + "/bevande",header)
  }

  // @ts-ignore
  dammiPiatto(name: string):Observable<Piatto>{
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    return this.http.get<Piatto>(this.backendUrl + "/piatto_scelto/" + name,header)


  }

  changePreferiti(piatto: string | undefined):void {
    var header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)
    }
    console.log("Aggiungi preferiti dentro auth" + piatto)
    console.log("Aggiungi preferiti dentro auth" + this.auth.token)

    this.http.post(this.backendUrl + "/preferitiChange/"+piatto+"/"+this.auth.token,header).subscribe(
      res => {
        console.log(res);
      }
    )

  }

  getPreferiti(piatto: string | undefined){
    var  header = {
      headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)


    }

    return this.http.get<boolean>(this.backendUrl + "/preferitiGet/"+piatto+"/"+this.auth.token,header)






  }


  dammiPreferiti() {
    var header = { headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token) }
    return this.http.get<Piatto[]>(this.backendUrl + "/preferitiPiatti", header)
  }

  piattiSearch(piatto: string | undefined):Observable<Piatto[]>{
    var header = { headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token) }
    return this.http.get<Piatto[]>(this.backendUrl + "/getSearch/"+piatto, header)
  }

  changeRecensione(recensione: string, piatto: string | undefined) {

    console.log("Invia recensione dentro auth" + recensione)
    console.log("Invia recensione dentro auth" + piatto)
    console.log("Invia recensione dentro auth" + this.auth.token)

    const header = {headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token)};

    return this.http.get<Boolean>(this.backendUrl + "/recensioneAdd/"+piatto+"/"+recensione,header)

  }


  getRecensito(nome: string | undefined) {
    var header = { headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token) }
    return this.http.get<boolean>(this.backendUrl + "/getRecensito/"+nome, header)

  }

  getRecensione(nome: string | undefined)  {
    var header = { headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token) }
    return this.http.get<Recensione>(this.backendUrl + `/getRecensione/`+ nome , header)


  }

  getAllRecensioni() {
    var header = { headers: new HttpHeaders().set('Authorization', 'Basic ' + this.auth.token) }
    return this.http.get<RecensioneCompleta[]>(this.backendUrl + `/getRecensione`, header)
  }

}

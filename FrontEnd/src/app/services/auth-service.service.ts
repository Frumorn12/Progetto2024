import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthToken, Utente } from '../model/utente';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  private backendUrl = "http://localhost:8080";
  public token?:string | null;

  getToken(){
    if (this.token == undefined){
      this.token = localStorage.getItem("ristoranti_token");
    }
    return this.token;
  }

  setToken(token:string){
    this.token = token;
    localStorage.setItem("ristoranti_token", token);

  }

  removeToken(){
    this.token = undefined;
    localStorage.removeItem("ristoranti_token");
    localStorage.removeItem("ristoranti_type");
  }

  setType(type:number){
    localStorage.setItem("ristoranti_type", type.toString());
  }

  getType(){
    return localStorage.getItem("ristoranti_type") ;

  }

  constructor(private http:HttpClient, private router:Router) { }

  checkAuthentication(){
    this.http.post<AuthToken>(this.backendUrl + "/isAuthenticated",
    {"Authorization":"Basic " + this.token}, {withCredentials: true}).subscribe(
      res => {
        if (!res){
          this.removeToken();
        }
      }
    );
  }

  isAuthenticated(){
    return this.getToken() != undefined;
  }

  isAuthenticatedAsAdmin() : boolean{
    console.log("STAMPO TIPO " + this.getType())
    return this.isAuthenticated() && this.getType() == "2";

  }

  login(username:string, password:string, tipo:number){
    var utente:Utente = {"username": username, "password": password, "tipo": tipo};
    return this.http.post<AuthToken>(this.backendUrl + "/login",utente,{withCredentials: true})

  }
  logout(){




    this.http.post<AuthToken>(this.backendUrl + "/logout",
    {"Authorization":"Basic " + this.token}, {withCredentials: true}).subscribe(
      res => {
        if (res){
          this.removeToken();
        }
        this.router.navigate(["/"]);
      }
    );


  }

  getUserByToken(): string {


    console.log("getUserByToken " + this.token)

    this.http.get<String>(this.backendUrl + "/getUserByToken/"+this.token,{withCredentials: true}).subscribe(
      res => {
        console.log("SONO DENTRO GET USER")
        return res;
      }
    );
    return "";
  }


  printList() {
    this.http.post(this.backendUrl + "/printList",{withCredentials: true})
    return true;
  }
}

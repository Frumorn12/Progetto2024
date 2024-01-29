import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AuthServiceService } from '../services/auth-service.service';
import {UtenteServiceService} from "../services/utente-service.service";
import {Router} from "@angular/router";
import {Observable} from "rxjs";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username = new FormControl();
  password = new FormControl();

  tipo: number = 0;




  constructor(private auth:AuthServiceService, private user1:UtenteServiceService, private router:Router){}

  faiLogin(){
    var user = this.username.value;
    var pass = this.password.value;

    this.user1.checkUtente(user).subscribe(
      response => {

        if(response){
          this.user1.getTipo(user).subscribe(
            response => {
              this.auth.login(user, pass,response).subscribe(
                response => {

                    console.log("STAMPO RESPONSE " + response.token)
                    this.auth.setType(response.utente.tipo);
                    this.auth.setToken(response.token);

                    this.router.navigate(["/"]);
                  })
              ;
            }
          )
        }
        else{
          alert("Username non esistente");
        }
      }
    )

  }


}

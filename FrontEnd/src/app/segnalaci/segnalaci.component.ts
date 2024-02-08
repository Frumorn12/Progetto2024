import { Component } from '@angular/core';
import {FormControl} from "@angular/forms";
import {UtenteServiceService} from "../services/utente-service.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-segnalaci',
  templateUrl: './segnalaci.component.html',
  styleUrls: ['./segnalaci.component.css']
})
export class SegnalaciComponent {
  formIsValid = false;
  richiesta = new FormControl();

  nome = new FormControl();
  cognome = new FormControl();

  email = new FormControl();
  commenti = new FormControl();

  constructor(private user: UtenteServiceService, private router: Router) {
  }


  go(){
    console.log("cliccato go in segnalaci")
    console.log(this.richiesta.value)
    this.user.segnalaci(this.richiesta.value,this.nome.value,this.cognome.value,this.email.value,this.commenti.value)
    this.router.navigate(['/']);

  }

  change() {
    this.updateFormValidity();

  }

  private updateFormValidity() {
    if(this.nome.value ==null || this.nome.value == '' || this.cognome.value == null || this.cognome.value == '' || this.email.value == null || this.email.value == '' || this.commenti.value == null || this.commenti.value == ''){
      this.formIsValid = false;

    }
    else if (this.nome.value.length < 2 || this.cognome.value.length < 2 || this.commenti.value.length < 10 || this.email.value == ""){
      this.formIsValid = false;
    }
    else {
      this.formIsValid = true;
    }}

}

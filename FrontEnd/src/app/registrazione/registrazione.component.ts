import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, NgForm} from "@angular/forms";
import {Router} from "@angular/router";
import {UtenteServiceService} from "../services/utente-service.service";
declare const calculateStrength: (password: string) => number; // Importa la funzione dalla logica JavaScript


declare const google: any;


@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})


export class RegistrazioneComponent{



  @ViewChild('myForm', { static: false }) registrationForm!: NgForm; // Aggiunta l'inizializzazione


  @ViewChild('indirizzo') addressInput: ElementRef | undefined;

  nome = new FormControl();
  cognome = new FormControl();
  username = new FormControl();

  email = new FormControl();
  data = new FormControl();
  via = new FormControl();
  civico = new FormControl();
  password1 = new FormControl();

  password: string = '';
  strength: number = 0;

  // Nel tuo componente TypeScript
  formIsValid = false;



  passwordLengthValid = false;

  constructor(private router: Router, private user: UtenteServiceService) {}





  onPasswordChange() {
    this.strength = calculateStrength(this.password);
    this.passwordLengthValid = this.password.length >= 8;
    console.log(this.formIsValid)
  }

  getStrengthColor() {
    // Restituisci uno stile CSS in base alla forza della password, ad esempio, un gradiente di colore
    const color = this.strength < 50 ? 'red' : 'green';
    return { 'background': `linear-gradient(to right, ${color} ${this.strength}%, #eee ${this.strength}%)` };
  }

  go(){
    console.log("TEST VEDO SE VA GO");
    this.user.registraUtente(this.username.value,this.password1.value,1,this.nome.value,this.cognome.value,this.data.value,this.via.value,this.civico.value,this.email.value).subscribe(
      (response) => {
        console.log("Registrato",response);
      },
      (error) => {
        console.error('Errore durante la registrazione:', error);
      }
  );

    this.router.navigate(['/']);

  }

  updateFormValidity() {
    // Controlla se tutti i campi richiesti sono stati toccati
    if(this.nome.value == null || this.cognome.value == null || this.username.value == null || this.email.value == null || this.data.value == null || this.via.value == null || this.civico.value == null ){
      this.formIsValid = false;
    }

    else if (this.nome.value == "" || this.cognome.value == "" || this.username.value == "" || this.email.value == "" || this.data.value == "" || this.via.value == "" || this.civico.value == "" ){
      this.formIsValid = false;
    }

    else {
      this.formIsValid = true;
    }
    console.log(this.formIsValid);
  }



  change() {
    this.updateFormValidity();

  }










}

import {Component, OnInit} from '@angular/core';
import {UtenteCompleto} from "../model/utente";
import {UtenteServiceService} from "../services/utente-service.service";

@Component({
  selector: 'app-gestione',
  templateUrl: './gestione.component.html',
  styleUrls: ['./gestione.component.css']
})
export class GestioneComponent implements OnInit{
  utente?:UtenteCompleto[] ;

  constructor(private user : UtenteServiceService) {
  }

  ngOnInit() {
    this.user.getAllUtente().subscribe(
      response => {
        this.utente = response;
      },
      error => {
        console.log(error);
      }
    );
  }


  bannaUtente(username: string) {
    this.user.changeTipo(username, 7).subscribe(
      response => {
        console.log(response);
        this.ngOnInit();
      },
      error => {
        console.log(error);
      }
    );

  }

  rendiAmministratore(username: string) {
    this.user.changeTipo(username, 2).subscribe(
      response => {
        console.log(response);
        this.ngOnInit();
      },
      error => {
        console.log(error);
      }
    );

  }

  rendiUtente(username: string) {
    this.user.changeTipo(username, 1).subscribe(
      response => {
        console.log(response);
        this.ngOnInit();
      },
      error => {
        console.log(error);
      }
    );

  }
}

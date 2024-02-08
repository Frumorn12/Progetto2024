import { Component } from '@angular/core';
import {Prenotazione} from "../model/prenotazione";
import {PrenotazioneServiceService} from "../services/prenotazione-service.service";

@Component({
  selector: 'app-prenotazione-utente',
  templateUrl: './prenotazione-utente.component.html',
  styleUrls: ['./prenotazione-utente.component.css']
})
export class PrenotazioneUtenteComponent {
  prenotazioni : Prenotazione[] = []

  constructor(private admin : PrenotazioneServiceService) {
  }

  ngOnInit() {
    this.admin.getAllPrenotazioneUtente().subscribe(
      response => {
        this.prenotazioni = response;
      },
      error => {
        console.log(error);
      }
    );
  }

}

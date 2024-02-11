import {Component, OnInit} from '@angular/core';
import {PrenotazioneServiceService} from "../services/prenotazione-service.service";
import {Segnalazione} from "../model/segnalazioni";

@Component({
  selector: 'app-tabella-segnalazioni',
  templateUrl: './tabella-segnalazioni.component.html',
  styleUrls: ['./tabella-segnalazioni.component.css']
})
export class TabellaSegnalazioniComponent implements OnInit{
  segnalazioni?: Segnalazione[];

  constructor(private user: PrenotazioneServiceService) {

  }

  ngOnInit() {
    console.log("STAMPO TABELLA ...")
    this.user.getAllSegnalazioni().subscribe(
      response => {
        this.segnalazioni = response;
        console.log("GET Request is successful ", response);
      },
      error => {
        console.log(error);
      }
    );
  }

}

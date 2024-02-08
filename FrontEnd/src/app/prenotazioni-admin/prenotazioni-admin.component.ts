import {Component, OnInit} from '@angular/core';
import {Prenotazione} from "../model/prenotazione";
import {PrenotazioneServiceService} from "../services/prenotazione-service.service";

@Component({
  selector: 'app-prenotazioni-admin',
  templateUrl: './prenotazioni-admin.component.html',
  styleUrls: ['./prenotazioni-admin.component.css']
})
export class PrenotazioniAdminComponent implements OnInit{
  prenotazioni : Prenotazione[] = []
  constructor(private admin : PrenotazioneServiceService) {

  }

  ngOnInit() {
    this.admin.getAllPrenotazione().subscribe(
      response => {
        this.prenotazioni = response;
      },
      error => {
        console.log(error);
      }
    );
  }
  accetta(id: number) {
    this.admin.accettaPrenotazione(id).subscribe(
      response => {
        console.log(response);
        this.ngOnInit()
      },
      error => {
        console.log(error);
      }
    );




  }

  rifiuta(id: number) {
    this.admin.rifiutaPrenotazione(id).subscribe(
      response => {
        console.log(response);
        this.ngOnInit()
      },
      error => {
        console.log(error);
      }
    );



  }
}

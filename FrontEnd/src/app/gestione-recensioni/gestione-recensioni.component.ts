import {Component, OnInit} from '@angular/core';
import {UtenteCompleto} from "../model/utente";
import {RecensioneCompleta} from "../model/recensione";
import {PiattiServiceService} from "../piatti-service.service";

@Component({
  selector: 'app-gestione-recensioni',
  templateUrl: './gestione-recensioni.component.html',
  styleUrls: ['./gestione-recensioni.component.css']
})
export class GestioneRecensioniComponent implements OnInit{
  recensioni?:RecensioneCompleta[] ;

  constructor(private piattiService:PiattiServiceService) {
  }
  ngOnInit() {
    this.piattiService.getAllRecensioni().subscribe(
      response => {
        this.recensioni = response;
      },
      error => {
        console.log(error);
      }
    );
  }
}

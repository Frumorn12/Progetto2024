import {Component, OnInit} from '@angular/core';
import {Ordine} from "../model/ordine";
import {OrdiniServiceService} from "../services/ordini-service.service";

@Component({
  selector: 'app-tabella-ordini',
  templateUrl: './tabella-ordini.component.html',
  styleUrls: ['./tabella-ordini.component.css']
})
export class TabellaOrdiniComponent implements OnInit{
  ordini: Ordine[] = []; // Assicurati che List e Ordini siano importati correttamente

  constructor(private ordineService : OrdiniServiceService) {

  }
  ngOnInit() {
    this.ordineService.getOrdini().subscribe(
      ordini => {
        this.ordini = ordini;
      }
    );

  }

}

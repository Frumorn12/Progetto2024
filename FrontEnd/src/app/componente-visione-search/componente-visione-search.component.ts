import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";

@Component({
  selector: 'app-componente-visione-search',
  templateUrl: './componente-visione-search.component.html',
  styleUrls: ['./componente-visione-search.component.css']
})


export class ComponenteVisioneSearchComponent implements OnInit {
  // Definisci una proprietà per memorizzare l'array di piatti
  piatti?: Piatto[];
  // Dichiara una variabile per memorizzare il parametro della route
  variabile: string = '';

  // Costruttore con iniezione delle dipendenze per ActivatedRoute e PiattiServiceService
  constructor(private route: ActivatedRoute, private serv: PiattiServiceService) { }

  // Hook del ciclo di vita, chiamato dopo che il componente è stato inizializzato
  ngOnInit(): void {
    // Recupera il parametro della route 'piatti' usando lo snapshot di ActivatedRoute
    this.variabile = this.route.snapshot.params['piatti'];

    // Chiama il metodo piattiSearch di PiattiServiceService con il parametro della route
    // Iscriviti all'observable per ottenere il risultato e assegnalo alla proprietà 'piatti'
    this.serv.piattiSearch(this.variabile).subscribe(
      piatti => this.piatti = piatti
    );

    // Registra il valore della variabile 'variabile' sulla console
    console.log("Stampo variabile piatto search : " + this.variabile);
  }
}

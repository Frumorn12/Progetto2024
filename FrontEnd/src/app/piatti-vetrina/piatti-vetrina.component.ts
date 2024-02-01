import {Component, Input, OnInit} from '@angular/core';
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";
import {AuthServiceService} from "../services/auth-service.service";

@Component({
  selector: 'app-piatti-vetrina',
  templateUrl: './piatti-vetrina.component.html',
  styleUrls: ['./piatti-vetrina.component.css']
})
export class PiattiVetrinaComponent implements OnInit{
  @Input()piatto?: Piatto;

  mostraRecensione: boolean = false;
  testoRecensione: string = '';

  preferito: boolean = false;

  constructor(private piattiService: PiattiServiceService, private aut:AuthServiceService) {
  }

  ngOnInit(): void {
    this.statoPreferito(this.piatto).subscribe(
      (preferito) => {
        this.preferito = preferito;
        console.log('Preferito ottenuto:', preferito);
      },
      (error) => {
        console.error('Errore durante la richiesta del preferito:', error);
      }
    );
    console.log("Preferito: " + this.piatto?.nome + " " + this.preferito);

  }

  toggleRecensione() : void {
    this.mostraRecensione = !this.mostraRecensione;
  }

  chiudiRecensione() : void {
    this.mostraRecensione = false;}

  isNotBevanda(){
    return this.piatto?.tipo != 8;
  }

  inviaRecensione() : void {
    // Aggiungi qui la logica per gestire l'invio della recensione
    console.log("Invia recensione dentro ts" + this.testoRecensione);
    this.piattiService.changeRecensione(this.testoRecensione, this.piatto?.nome);
    this.mostraRecensione = false;
  }

  aggiungiPreferiti(piatto: Piatto | undefined){
    // Aggiungi qui la logica per gestire l'aggiunta della recensione
    console.log("Aggiungi preferiti dentro ts" + piatto?.nome)

    this.piattiService.changePreferiti(piatto?.nome);
    this.preferito = !this.preferito;



  }


  statoPreferito(piatto: Piatto | undefined){
    return this.piattiService.getPreferiti(piatto?.nome);



  }

  isAut(){
    return this.aut.isAuthenticated();
  }











}

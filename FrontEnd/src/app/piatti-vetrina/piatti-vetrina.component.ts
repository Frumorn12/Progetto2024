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

  recensito: boolean = false;

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

    this.statoRecensito(this.piatto).subscribe(
      (recensito) => {
        this.recensito = recensito;
        console.log('Recensito ottenuto:', recensito);
      },
      (error) => {
        console.error('Errore durante la richiesta del recensito:', error);
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
    console.log("Invia recensione dentro ts" + this.testoRecensione);
    this.piattiService.changeRecensione(this.testoRecensione, this.piatto?.nome).subscribe(
      (response) => {
        console.log(response);
        this.mostraRecensione = false;
        this.recensito = true;
      },
      (error) => console.log(error)
    );


  }

  aggiungiPreferiti(piatto: Piatto | undefined){
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


  private statoRecensito(piatto: Piatto | undefined) {
    return this.piattiService.getRecensito(piatto?.nome);

  }
}

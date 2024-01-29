import {Component, Input, OnInit} from '@angular/core';
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";
import {CarrelloServiceService} from "../services/carrello-service.service";
import {Carrello} from "../model/carrello";

@Component({
  selector: 'app-sezione-menu-vetrina',
  templateUrl: './sezione-menu-vetrina.component.html',
  styleUrls: ['./sezione-menu-vetrina.component.css']
})
export class SezioneMenuVetrinaComponent implements OnInit{
  antipasto?:Piatto[]
  primo?:Piatto[]
  secondo?:Piatto[]
  contorno?:Piatto[]
  dolce?:Piatto[]
  senzaLattosio?:Piatto[]
  senzaGlutine?:Piatto[]
  bevanda?:Piatto[]
  carrello?:Carrello[]




  constructor(private piattiService:PiattiServiceService, private carrelloService:CarrelloServiceService){}
  ngOnInit(){
    this.getPiatti();
    this.getCarrello();
  }


  private getPiatti() {
    this.piattiService.dammiAntipasti().subscribe
    (piatti => this.antipasto = piatti);
    this.piattiService.dammiPrimi().subscribe
    (piatti => this.primo = piatti);
    this.piattiService.dammiSecondi().subscribe
    (piatti => this.secondo = piatti);
    this.piattiService.dammiContorni().subscribe
    (piatti => this.contorno = piatti);
    this.piattiService.dammiDolci().subscribe
    (piatti => this.dolce = piatti);
    this.piattiService.dammiSenzaLattosio().subscribe
    (piatti => this.senzaLattosio = piatti);
    this.piattiService.dammiSenzaGlutine().subscribe
    (piatti => this.senzaGlutine = piatti);
    this.piattiService.dammiBevande().subscribe
    (piatti => this.bevanda = piatti);

  }

  public getCarrello() {
    this.carrelloService.getCarrello().subscribe
    (carrello => this.carrello = carrello);


  }

  calculateTotal(): number {
    // @ts-ignore
    return this.carrello.reduce((total, item) => total + item.prezzo * item.quantita, 0);
  }
}

import {Component, OnInit} from '@angular/core';
import {PiattiServiceService} from "../piatti-service.service";
import {Ingrediente} from "../model/ingrediente";
import {Piatto} from "../model/piatto";
import {HamburgerServiceService} from "../services/hamburger-service.service";
import {Hamburger} from "../model/hamburger";
import {Immagini} from "../model/immagini";

@Component({
  selector: 'app-creapiatto',
  templateUrl: './creapiatto.component.html',
  styleUrls: ['./creapiatto.component.css']
})
// Classe del componente CreapiattoComponent che implementa OnInit
export class CreapiattoComponent implements OnInit{
  // Dichiarazione di variabili per immagazzinare dati da servizi
  base?:Ingrediente[]
  ingrediente?:Ingrediente[]
  salsa?:Ingrediente[]
  carne?:Ingrediente[]
  contorno?:Ingrediente[]
  bevande?:Ingrediente[]

  hamburger?:Hamburger[]
  immagini?: Immagini[];


  constructor(private piattiService:PiattiServiceService, private hamburgerService:HamburgerServiceService){}


  ngOnInit(){
    this.getIngredienti();
    this.getCarrello();

  }

  private getIngredienti() {
// Chiamate ai servizi per ottenere i vari tipi di ingredienti
    this.hamburgerService.dammiBase().subscribe(
      base => this.base = base
    );
    this.hamburgerService.dammiIngredienti().subscribe(
      ingrediente => this.ingrediente = ingrediente
    );
    this.hamburgerService.dammiSalsa().subscribe(
      salsa => this.salsa = salsa
    );
    this.hamburgerService.dammiCarne().subscribe(
      carne => this.carne = carne
    );
    // Chiamate ai servizi per ottenere contorni e bevande
    this.hamburgerService.dammiContorno().subscribe(
      contorno => this.contorno = contorno
    );

    this.hamburgerService.dammiBevande().subscribe(
      bevande => this.bevande = bevande
    );

  }
// Metodo pubblico per ottenere il carrello dal servizio
  public getCarrello(){
    this.hamburgerService.getHamburger().subscribe
    (hamburger => this.hamburger = hamburger);
    this.getImmagini();


  }
// Metodo per calcolare il totale del carrello
  calculateTotal(){
    // @ts-ignore
    return this.hamburger.reduce((total, item) => total + item.prezzo * item.quantita, 0);

  }


  private getImmagini() {
    this.hamburgerService.dammiImmagini().subscribe(
      immagini => this.immagini = immagini
    );

  }
}

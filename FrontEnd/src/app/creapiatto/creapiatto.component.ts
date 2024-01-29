import {Component, OnInit} from '@angular/core';
import {PiattiServiceService} from "../piatti-service.service";
import {Ingrediente} from "../model/ingrediente";
import {Piatto} from "../model/piatto";
import {HamburgerServiceService} from "../services/hamburger-service.service";
import {Hamburger} from "../model/hamburger";

@Component({
  selector: 'app-creapiatto',
  templateUrl: './creapiatto.component.html',
  styleUrls: ['./creapiatto.component.css']
})
export class CreapiattoComponent implements OnInit{
  base?:Ingrediente[]
  ingrediente?:Ingrediente[]
  salsa?:Ingrediente[]
  carne?:Ingrediente[]
  contorno?:Piatto[]
  bevanda?:Piatto[]
  hamburger?:Hamburger[]

  constructor(private piattiService:PiattiServiceService, private hamburgerService:HamburgerServiceService){}


  ngOnInit(){
    this.getIngredienti();
    this.getCarrello();
  }

  private getIngredienti() {

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
    this.piattiService.dammiContorni().subscribe
    (piatti => this.contorno = piatti);

    this.piattiService.dammiBevande().subscribe
    (piatti => this.bevanda = piatti);

  }

  public getCarrello(){
    this.hamburgerService.getHamburger().subscribe
    (hamburger => this.hamburger = hamburger);
  }

  calculateTotal(){
    // @ts-ignore
    return this.hamburger.reduce((total, item) => total + item.prezzo * item.quantita, 0);

  }


}

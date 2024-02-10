import {Component, Input, OnInit} from '@angular/core';
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";

@Component({
  selector: 'app-sezione-piatti-vetrina',
  templateUrl: './sezione-piatti-vetrina.component.html',
  styleUrls: ['./sezione-piatti-vetrina.component.css']
})
export class SezionePiattiVetrinaComponent implements OnInit{
  @Input()tipo?:number;
  piatti?:Piatto[]
  nome?:string;

  constructor(private piattiService:PiattiServiceService){}

  ngOnInit(){
    this.getPiatti();
  }

  getPiatti(){
    if (this.tipo == 1){
      this.piattiService.dammiAntipasti().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Antipasti";
      });


    }
    else if (this.tipo == 2){
      this.piattiService.dammiPrimi().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Primi";
      });
    }
    else if (this.tipo == 3){
      this.piattiService.dammiSecondi().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Secondi";
      });
    }
    else if (this.tipo == 4){
      this.piattiService.dammiContorni().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Contorni";
      });
    }
    else if (this.tipo == 5){
      this.piattiService.dammiDolci().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Dolci";
      });
    }
    else if (this.tipo == 6){
      this.piattiService.dammiSenzaLattosio().subscribe(
        piatti => {
          this.piatti = piatti
          this.nome = "Senza Lattosio";
        }
      )
    }
    else if (this.tipo == 7){
      this.piattiService.dammiSenzaGlutine().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Senza Glutine";
      });
    }
    else if (this.tipo == 8){
      this.piattiService.dammiBevande().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Bevande";
      });
    }
    else if (this.tipo == 9){
      this.piattiService.dammiPreferiti().subscribe
      (piatti => {
        this.piatti = piatti
        this.nome = "Preferiti";
      });
    }



  }


}

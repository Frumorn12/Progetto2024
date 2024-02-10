import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Piatto} from "../model/piatto";
import {CarrelloServiceService} from "../services/carrello-service.service";
import {Ingrediente} from "../model/ingrediente";
import {HamburgerServiceService} from "../services/hamburger-service.service";
import {Immagini} from "../model/immagini";

@Component({
  selector: 'app-hamburger-card',
  templateUrl: './hamburger-card.component.html',
  styleUrls: ['./hamburger-card.component.css']
})
export class HamburgerCardComponent implements OnInit {

  @Input() ingrediente?: Ingrediente;
  @Output() ingredienteAggiunto = new EventEmitter<any>();
  immagine?: Immagini;



  constructor(private hambugerService: HamburgerServiceService) {
  }

  ngOnInit() {
    this.hambugerService.dammiImmagine(this.ingrediente?.nome).subscribe(
      (response) => {

        this.immagine = response;
        console.log(this.immagine?.immagine + " " + this.ingrediente?.nome)
      },
      (error) => console.log(error)
    );
  }


  onCardClick() {

    this.hambugerService.addIngrediente(this.ingrediente).subscribe(
      (response) => {
        console.log(response);
        this.ingredienteAggiunto.emit();
      },
      (error) => console.log(error)
    );

  }



  delete(){
    this.hambugerService.deleteIngrediente(this.ingrediente).subscribe(
      (response) => {
        console.log(response);
        this.ingredienteAggiunto.emit();
      },
      (error) => console.log(error)
    );

  }



}

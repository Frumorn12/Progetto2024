import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Piatto} from "../model/piatto";
import {CarrelloServiceService} from "../services/carrello-service.service";
import {Ingrediente} from "../model/ingrediente";
import {HamburgerServiceService} from "../services/hamburger-service.service";

@Component({
  selector: 'app-hamburger-card',
  templateUrl: './hamburger-card.component.html',
  styleUrls: ['./hamburger-card.component.css']
})
export class HamburgerCardComponent {

  @Input() ingrediente?: Ingrediente;
  @Output() ingredienteAggiunto = new EventEmitter<any>();



  constructor(private hambugerService: HamburgerServiceService) {
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

  }



}

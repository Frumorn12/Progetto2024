import {Component, Input} from '@angular/core';
import {Hamburger} from "../model/hamburger";

@Component({
  selector: 'app-carrello',
  templateUrl: './carrello.component.html',
  styleUrls: ['./carrello.component.css']
})
export class CarrelloComponent {
  @Input() carrello?: Hamburger[];

  calculateTotal(){
    // @ts-ignore
    return this.hamburger.reduce((total, item) => total + item.prezzo * item.quantita, 0);

  }

}

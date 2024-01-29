import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Piatto} from "../model/piatto";
import {consolidateMessages} from "@angular/localize/tools/src/extract/translation_files/utils";
import {CarrelloServiceService} from "../services/carrello-service.service";

@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.component.html',
  styleUrls: ['./menu-card.component.css']
})
export class MenuCardComponent  {
  @Input() piatto?: Piatto;
  @Output() piattoAggiunto = new EventEmitter<any>();



  constructor(private carrelloService: CarrelloServiceService) {
  }


  onCardClick() {
    this.carrelloService.addPiatto(this.piatto).subscribe(
      (response) => {
        console.log(response);
        this.piattoAggiunto.emit();
      },
      (error) => console.log(error)
    );

  }

  delete(){
    this.carrelloService.deletePiatto(this.piatto).subscribe(
      (response) => {
        console.log(response);
        this.piattoAggiunto.emit();
      },
      (error) => console.log(error)
    );
}

}

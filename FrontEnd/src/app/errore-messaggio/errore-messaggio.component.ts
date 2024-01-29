import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-errore-messaggio',
  templateUrl: './errore-messaggio.component.html',
  styleUrls: ['./errore-messaggio.component.css']
})
export class ErroreMessaggioComponent {
  @Input() messaggio: string = '';

}

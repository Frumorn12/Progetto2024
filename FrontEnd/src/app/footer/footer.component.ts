import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  // Dichiarazione di proprietà per immagazzinare dati (email e numero di telefono)
  email:string = "krusty.krab@mat.unical.it"
  numero:string = "328 186 1231"
}

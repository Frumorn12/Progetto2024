// Importa la classe `Component` dal modulo '@angular/core'
import { Component } from '@angular/core';

// Definisce il componente Angular con il selettore 'app-prenotazioneasporto'
// e specifica il file HTML e il file CSS associati a questo componente.
@Component({
  selector: 'app-prenotazioneasporto',
  templateUrl: './prenotazioneasporto.component.html',
  styleUrls: ['./prenotazioneasporto.component.css']
})

// Definisce la classe del componente chiamata PrenotazioneasportoComponent
export class PrenotazioneasportoComponent {
  // Dichiarazione di una variabile 'antipasti' inizializzata a 1
  antipasti = 1;
}


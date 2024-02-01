// Importa la classe `Component` dal modulo '@angular/core'
import { Component } from '@angular/core';

// Definisce il componente Angular con il selettore 'app-preferiti'
// e specifica il file HTML e il file CSS associati a questo componente.
@Component({
  selector: 'app-preferiti', // Selettore del componente nell'HTML
  templateUrl: './preferiti.component.html', // Percorso al file HTML del componente
  styleUrls: ['./preferiti.component.css'] // Percorso ai file CSS del componente
})

// Definisce la classe del componente chiamata PreferitiComponent
export class PreferitiComponent {
  // Proprietà del componente che rappresenta il numero di preferiti (valore iniziale: 9)
  preferiti = 9;
}


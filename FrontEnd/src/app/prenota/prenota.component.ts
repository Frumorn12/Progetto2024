// Importa la classe `Component` dal modulo '@angular/core'
import { Component } from '@angular/core';

// Definisce il componente Angular con il selettore 'app-prenota'
// e specifica il file HTML e il file CSS associati a questo componente.
@Component({
  selector: 'app-prenota', // Selettore del componente nell'HTML
  templateUrl: './prenota.component.html', // Percorso al file HTML del componente
  styleUrls: ['./prenota.component.css'] // Percorso ai file CSS del componente
})

// Definisce la classe del componente chiamata PrenotaComponent
export class PrenotaComponent {
  // Questa classe è vuota al momento. Puoi aggiungere qui le proprietà e i metodi
  // necessari per implementare la logica del tuo componente.
}


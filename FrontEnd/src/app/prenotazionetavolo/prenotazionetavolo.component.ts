// Importa la classe `Component` dal modulo '@angular/core'
import { Component } from '@angular/core';

// Definisce il componente Angular con il selettore 'app-prenotazionetavolo'
// e specifica il file HTML e il file CSS associati a questo componente.
@Component({
  selector: 'app-prenotazionetavolo', // Selettore del componente nell'HTML
  templateUrl: './prenotazionetavolo.component.html', // Percorso al file HTML del componente
  styleUrls: ['./prenotazionetavolo.component.css'] // Percorso ai file CSS del componente
})

// Definisce la classe del componente chiamata PrenotazionetavoloComponent
export class PrenotazionetavoloComponent {
  // Questa classe è vuota al momento. Puoi aggiungere qui le proprietà e i metodi
  // necessari per implementare la logica del tuo componente.
}


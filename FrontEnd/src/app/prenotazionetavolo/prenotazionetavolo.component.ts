// Importa la classe `Component` dal modulo '@angular/core'
import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {PrenotazioneServiceService} from "../services/prenotazione-service.service";
import {Router} from "@angular/router";




// Definisce il componente Angular con il selettore 'app-prenotazionetavolo'
// e specifica il file HTML e il file CSS associati a questo componente.
@Component({
  selector: 'app-prenotazionetavolo', // Selettore del componente nell'HTML
  templateUrl: './prenotazionetavolo.component.html', // Percorso al file HTML del componente
  styleUrls: ['./prenotazionetavolo.component.css'] // Percorso ai file CSS del componente
})

// Definisce la classe del componente chiamata PrenotazionetavoloComponent
export class PrenotazionetavoloComponent  implements  OnInit{
  // Questa classe è vuota al momento. Puoi aggiungere qui le proprietà e i metodi
  // necessari per implementare la logica del tuo componente.
  constructor(private prenotazione: PrenotazioneServiceService, private router: Router) {
    const oggi = new Date();
    this.minDate = oggi.toISOString().split('T')[0];
  }
  nome = new FormControl();
  cognome = new FormControl();
  email = new FormControl();
  telefono = new FormControl();
  data = new FormControl();
  commenti = new FormControl();

  minDate: string;

  datePrenotate: string[] = [];

  dateValid = false;

  count = 0; // Contatore per il numero di prenotazioni

  go() {
    this.prenotazione.mettiPrenotazioneTavola(this.nome.value, this.cognome.value, this.email.value, this.telefono.value, this.data.value, this.commenti.value);
    this.router.navigate(['/']);

  }

  ngOnInit() {
    this.prenotazione.prendiDate().subscribe(
      data => {
        this.datePrenotate = data;
      }
    )


  }


  checkDate() {

    for (let i = 0; i < this.datePrenotate.length; i++) {
      console.log(this.datePrenotate[i] + "STAMPO DATE ");
      if (this.datePrenotate[i] === this.data.value) {

        this.count++;
      }
    }
    if (this.count >= 2) {
      this.dateValid = false;
    } else {
      this.dateValid = true;
    }
    this.count = 0;
    return ;
  }
}


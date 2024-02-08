import {AfterViewInit, Component, ElementRef, OnInit} from '@angular/core';
import Typed from "typed.js";

@Component({
  selector: 'app-chi-siamo',
  templateUrl: './chi-siamo.component.html',
  styleUrls: ['./chi-siamo.component.css']
})
export class ChiSiamoComponent implements OnInit {


  ngOnInit() {
    // Opzioni di configurazione di Typed.js
    // @ts-ignore
    const options: Typed.TypedOptions = {
      strings: ['Benvenuti nel nostro ristorante', 'Benvenuti al Krusty Krab ♥'],
      animation: 'none',


      typeSpeed: 50,
      backSpeed: 25,

    };

    // Creare un'istanza di Typed.js
    const typed = new Typed('.elemento-da-scivolare', options);
  }


}

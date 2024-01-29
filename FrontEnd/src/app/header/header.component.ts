import {Component, OnInit} from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';
import {FormControl} from "@angular/forms";
import {map, Observable, startWith} from "rxjs";

declare function getRandomPhoto(): string;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})


export class HeaderComponent  {


  searchOnEnter(event: any): void {
    // Verifica che l'evento sia generato dalla pressione del tasto "Invio"
    if (event instanceof KeyboardEvent && event.key === 'Enter') {
      // Chiamare la tua funzione di ricerca qui
      this.performSearch();
    }
  }

  // La tua funzione di ricerca
  performSearch(): void {
    // Implementa la logica di ricerca qui
    console.log('Esegui la ricerca...');
  }







  constructor(private authService: AuthServiceService){}



  isAuthenticated(){
    return this.authService.isAuthenticated();
  }
  doLogout(){
    console.log("click");
    this.authService.logout();
  }


}

import {Component, OnInit} from '@angular/core';
import { AuthServiceService } from '../services/auth-service.service';
import {FormControl} from "@angular/forms";
import {map, Observable, startWith} from "rxjs";
import {Router, RouterModule} from "@angular/router";
import {PiattiServiceService} from "../piatti-service.service";

declare function getRandomPhoto(): string;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})


export class HeaderComponent  {
  searchTerm = new FormControl();

  constructor(private authService: AuthServiceService, private router : Router, private piatti: PiattiServiceService){}



  searchOnEnter(event: any, string: string): void {
    // Verifica che l'evento sia generato dalla pressione del tasto "Invio"
    if (event instanceof KeyboardEvent && event.key === 'Enter') {
      // Chiamare la tua funzione di ricerca qui
      this.performSearch(string);
    }
  }

  // La tua funzione di ricerca
  performSearch(piatti : string): void {
    this.router.navigateByUrl('/', {skipLocationChange: true}).then(() =>
      this.router.navigate(['/search', piatti]));






  }










  isAuthenticated(){
    return this.authService.isAuthenticated() ;
  }
  doLogout(){
    console.log("click");
    this.authService.logout();
  }


  isAuthenticatedAsAdmin() {
    return this.authService.isAuthenticatedAsAdmin();
  }
}

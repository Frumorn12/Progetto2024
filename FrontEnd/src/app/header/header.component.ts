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


export class HeaderComponent  implements OnInit{

  provinceList: string[] = [
    'Agrigento',
    'Alessandria',
    // Aggiungi altre province qui
  ];

  items = [
    { code: '0', name: 'Red' },
    { code: '1', name: 'Blue' },
    { code: '2', name: 'Green' },
    { code: '3', name: 'Yellow' },
    { code: '4', name: 'Black' },
    { code: '5', name: 'Purple' },
    { code: '6', name: 'White' },
    { code: '7', name: 'Grey' },
  ];

  ngOnInit(): void {
    this.populateDropdown();
  }

  populateDropdown(): void {
    const selectElement = document.querySelector('#accessibleAutocomplete');

    this.provinceList.forEach(province => {
      const option = document.createElement('option');
      option.value = province;
      option.textContent = province;
      // @ts-ignore
      selectElement.appendChild(option);
    });
  }





  constructor(private authService: AuthServiceService){}

  getRandomPhotoUrl(){
    console.log(getRandomPhoto());
    return getRandomPhoto();
  }

  isAuthenticated(){
    return this.authService.isAuthenticated();
  }
  doLogout(){
    console.log("click");
    this.authService.logout();
  }


}

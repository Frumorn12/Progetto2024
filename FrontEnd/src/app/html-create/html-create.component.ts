import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-html-create',
  templateUrl: './html-create.component.html',
  styleUrls: ['./html-create.component.css']
})
export class HtmlCreateComponent implements OnInit{
  name: string | null = this.route.snapshot.paramMap.get('name');
  piatto : Piatto | null = null ;





    constructor(private route: ActivatedRoute, private piattiservice:PiattiServiceService) {}

  ngOnInit(): void {
    // Retrieve the ID parameter from the route
    this.caricaPiattoDesiderato(this.name!)

  }
  caricaPiattoDesiderato(nomePiatto: string): void {
    this.piattiservice.dammiPiatto(nomePiatto).subscribe(
      (piatto) => {
        this.piatto = piatto;
        console.log('Piatto ottenuto:', piatto);
      },
      (error) => {
        console.error('Errore durante la richiesta del piatto:', error);
      }
    );







}}

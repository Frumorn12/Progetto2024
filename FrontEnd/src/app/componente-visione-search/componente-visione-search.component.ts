import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Piatto} from "../model/piatto";
import {PiattiServiceService} from "../piatti-service.service";

@Component({
  selector: 'app-componente-visione-search',
  templateUrl: './componente-visione-search.component.html',
  styleUrls: ['./componente-visione-search.component.css']
})
export class ComponenteVisioneSearchComponent implements OnInit{
    piatti?: Piatto[];
    variabile : string = '';


  constructor(private route: ActivatedRoute, private serv : PiattiServiceService) { }

    ngOnInit(): void {
      this.variabile = this.route.snapshot.params['piatti'];
      this.serv.piattiSearch(this.variabile).subscribe(
        piatti => this.piatti = piatti
      );
      console.log("Stampo variabile piatto search : "+ this.variabile)

    }



}

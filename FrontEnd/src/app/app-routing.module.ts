import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChiSiamoComponent } from './chi-siamo/chi-siamo.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RecensioniComponent } from './recensioni/recensioni.component';
import { AuthGuardService } from './auth-guard.service';
import { PiattiComponent} from "./piatti/piatti.component";
import {AntipastiComponent} from "./antipasti/antipasti.component";
import {HtmlCreateComponent} from "./html-create/html-create.component";
import {PrimiComponent} from "./primi/primi.component";
import {SecondiComponent} from "./secondi/secondi.component";
import {ContorniComponent} from "./contorni/contorni.component";
import {DolciComponent} from "./dolci/dolci.component";
import {SenzalattosioComponent} from "./senzalattosio/senzalattosio.component";
import {SenzaglutineComponent} from "./senzaglutine/senzaglutine.component";
import {BevandeComponent} from "./bevande/bevande.component";
import {PrenotaComponent} from "./prenota/prenota.component";
import {SegnalaciComponent} from "./segnalaci/segnalaci.component";
import {PrenotazioneasportoComponent} from "./prenotazioneasporto/prenotazioneasporto.component";
import {PrenotazionetavoloComponent} from "./prenotazionetavolo/prenotazionetavolo.component";
import {RegistrazioneComponent} from "./registrazione/registrazione.component";
import {PreferitiComponent} from "./preferiti/preferiti.component";
import {SezioneMenuVetrinaComponent} from "./sezione-menu-vetrina/sezione-menu-vetrina.component";
import {CreapiattoComponent} from "./creapiatto/creapiatto.component";
import {GestioneComponent} from "./gestione/gestione.component";
import {ComponenteVisioneSearchComponent} from "./componente-visione-search/componente-visione-search.component";
const routes: Routes = [
  {"path" : "", component:HomeComponent},
  {"path" : "chi_siamo", component:ChiSiamoComponent},
  {"path" : "login", component:LoginComponent},
  {"path" : "recensioni", component:RecensioniComponent, canActivate:[AuthGuardService]},
  {"path" : "piatti", component:PiattiComponent},
  {"path" : "antipasti", component:AntipastiComponent},
  {"path" : "primi", component:PrimiComponent},
  {"path" : "secondi", component:SecondiComponent},
  {"path" : "contorni", component:ContorniComponent},
  {"path" : "dolci", component:DolciComponent},
  {"path" : "senzalattosio", component:SenzalattosioComponent},
  {"path" : "senzaglutine", component:SenzaglutineComponent},
  {"path" : "bevande", component:BevandeComponent},
  {"path" : "preferiti", component:PreferitiComponent},
  {"path" : "prenotazione", component:PrenotaComponent},
  {"path" : "prenotazioneasporto", component:PrenotazioneasportoComponent},
  {"path" : "prenotazionetavolo", component:PrenotazionetavoloComponent},
  {"path" : "segnalazione", component:SegnalaciComponent},
  {"path" : "registrazione", component:RegistrazioneComponent},
  {"path" : "sezione-menu-vetrina", component:SezioneMenuVetrinaComponent},
  {"path" : "crea-piatto", component:CreapiattoComponent},
  {"path" : "gestione", component:GestioneComponent},
  {"path" : "search/:piatti", component:ComponenteVisioneSearchComponent},




  {"path" : "html/:name", component:HtmlCreateComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

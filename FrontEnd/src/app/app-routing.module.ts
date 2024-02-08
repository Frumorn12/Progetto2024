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
import {GestioneRecensioniComponent} from "./gestione-recensioni/gestione-recensioni.component";
import {TabellaOrdiniComponent} from "./tabella-ordini/tabella-ordini.component";
import {AuthGuardAdminServiceService} from "./auth-guard-admin-service.service";
import {PrenotazioniAdminComponent} from "./prenotazioni-admin/prenotazioni-admin.component";
import {PrenotazioneUtenteComponent} from "./prenotazione-utente/prenotazione-utente.component";
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
  {"path" : "preferiti", component:PreferitiComponent, canActivate:[AuthGuardService]},
  {"path" : "prenotazione", component:PrenotaComponent, canActivate:[AuthGuardService]},
  {"path" : "prenotazioneasporto", component:PrenotazioneasportoComponent ,canActivate:[AuthGuardService]},
  {"path" : "prenotazionetavolo", component:PrenotazionetavoloComponent, canActivate:[AuthGuardService]},
  {"path" : "segnalazione", component:SegnalaciComponent},
  {"path" : "registrazione", component:RegistrazioneComponent},
  {"path" : "sezione-menu-vetrina", component:SezioneMenuVetrinaComponent},
  {"path" : "crea-piatto", component:CreapiattoComponent, canActivate:[AuthGuardService]},
  {"path" : "gestione", component:GestioneComponent,canActivate:[AuthGuardAdminServiceService]},
  {"path" : "search/:piatti", component:ComponenteVisioneSearchComponent},
  {"path" : "gestioneRecensioni", component:GestioneRecensioniComponent, canActivate:[AuthGuardAdminServiceService]},
  {"path" : "ordini", component:TabellaOrdiniComponent, canActivate:[AuthGuardService]},
  {"path" : "prenotazioni_admin", component:PrenotazioniAdminComponent, canActivate:[AuthGuardAdminServiceService]},
  {"path" : "prenotazioni_utenti", component:PrenotazioneUtenteComponent, canActivate:[AuthGuardService]},


  {"path" : "html/:name", component:HtmlCreateComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ChiSiamoComponent } from './chi-siamo/chi-siamo.component';
import { RistoranteVetrinaComponent } from './ristorante-vetrina/ristorante-vetrina.component';
import { SezioneRistoranteVetrinaComponent } from './sezione-ristorante-vetrina/sezione-ristorante-vetrina.component';
import { CommonModule, NgFor } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PiattiComponent } from './piatti/piatti.component';
import { PiattiVetrinaComponent } from './piatti-vetrina/piatti-vetrina.component';
import { PiattiServiceService } from "./piatti-service.service";
import { AntipastiComponent } from './antipasti/antipasti.component';
import { SezionePiattiVetrinaComponent } from './sezione-piatti-vetrina/sezione-piatti-vetrina.component';
import { HtmlCreateComponent } from './html-create/html-create.component';
import { PrimiComponent } from './primi/primi.component';
import { SecondiComponent } from './secondi/secondi.component';
import { ContorniComponent } from './contorni/contorni.component';
import { DolciComponent } from './dolci/dolci.component';
import { SenzalattosioComponent } from './senzalattosio/senzalattosio.component';
import { SenzaglutineComponent } from './senzaglutine/senzaglutine.component';
import { BevandeComponent } from './bevande/bevande.component';
import { PrenotaComponent } from './prenota/prenota.component';
import { SegnalaciComponent } from './segnalaci/segnalaci.component';
import { PrenotazioneasportoComponent } from './prenotazioneasporto/prenotazioneasporto.component';
import { PrenotazionetavoloComponent } from './prenotazionetavolo/prenotazionetavolo.component';
import { MenuModule } from '@progress/kendo-angular-menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrazioneComponent } from './registrazione/registrazione.component';
import { ErroreMessaggioComponent } from './errore-messaggio/errore-messaggio.component';
import { UtenteServiceService } from "./services/utente-service.service";
import { PreferitiComponent } from './preferiti/preferiti.component';
import { MenuCardComponent } from './menu-card/menu-card.component';
import { SezioneMenuVetrinaComponent } from './sezione-menu-vetrina/sezione-menu-vetrina.component';
import { CreapiattoComponent } from './creapiatto/creapiatto.component';
import { HamburgerCardComponent } from './hamburger-card/hamburger-card.component';
import { GestioneComponent } from './gestione/gestione.component';

import { OverlayModule } from '@angular/cdk/overlay';
import { CdkTreeModule } from '@angular/cdk/tree';
import { PortalModule } from '@angular/cdk/portal';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatRippleModule } from '@angular/material/core';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTreeModule } from '@angular/material/tree';
import { MatBadgeModule } from '@angular/material/badge';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatTooltipModule } from '@angular/material/tooltip';
import { ComponenteVisioneSearchComponent } from './componente-visione-search/componente-visione-search.component';
import { CarrelloComponent } from './carrello/carrello.component';
import { GestioneRecensioniComponent } from './gestione-recensioni/gestione-recensioni.component';
import {PrenotazioneServiceService} from "./services/prenotazione-service.service";

import Typed from 'typed.js';
import { TabellaOrdiniComponent } from './tabella-ordini/tabella-ordini.component';
import { KendoDatepickerComponent } from './kendo-datepicker/kendo-datepicker.component';
import { DateInputsModule } from '@progress/kendo-angular-dateinputs';
import { PrenotazioniAdminComponent } from './prenotazioni-admin/prenotazioni-admin.component';
import { PrenotazioneUtenteComponent } from './prenotazione-utente/prenotazione-utente.component';




//I keep the new line

//I keep the new line
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    ChiSiamoComponent,
    RistoranteVetrinaComponent,
    SezioneRistoranteVetrinaComponent,
    LoginComponent,
    SidebarComponent,
    PiattiComponent,
    PiattiVetrinaComponent,
    AntipastiComponent,
    SezionePiattiVetrinaComponent,
    HtmlCreateComponent,
    PrimiComponent,
    SecondiComponent,
    ContorniComponent,
    DolciComponent,
    SenzalattosioComponent,
    SenzaglutineComponent,
    BevandeComponent,
    PrenotaComponent,
    SegnalaciComponent,
    PrenotazioneasportoComponent,
    PrenotazionetavoloComponent,
    RegistrazioneComponent,
    ErroreMessaggioComponent,
    PreferitiComponent,
    MenuCardComponent,

    SezioneMenuVetrinaComponent,
    CreapiattoComponent,
    HamburgerCardComponent,
    GestioneComponent,
    ComponenteVisioneSearchComponent,
    CarrelloComponent,
    GestioneRecensioniComponent,
    TabellaOrdiniComponent,
    KendoDatepickerComponent,
    PrenotazioniAdminComponent,
    PrenotazioneUtenteComponent,

    //I keep the new line
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgFor,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    MenuModule,
    BrowserAnimationsModule,

    CdkTreeModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDividerModule,
    MatExpansionModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatProgressSpinnerModule,
    MatPaginatorModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatButtonToggleModule,
    MatTreeModule,
    OverlayModule,
    PortalModule,
    MatBadgeModule,
    MatGridListModule,
    MatRadioModule,
    MatDatepickerModule,
    MatTooltipModule,
    DateInputsModule,

  ],
  providers: [PiattiServiceService, UtenteServiceService, PrenotazioneServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}

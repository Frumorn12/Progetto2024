import {Recensione, RecensioneCompleta} from "./recensione";

export interface Piatto{

  nome:string;
  ingredienti:string;
  descrizione:string;
  preparazione:string;
  tipo:number;
  immagine:string;
  prezzo:number;
  recensioni:RecensioneCompleta[];


}

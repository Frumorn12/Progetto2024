export interface Utente{
    username:string;
    password:string;
    tipo:number;
}

export interface UtenteCompleto{
  username:string;
  tipo:number;
  email:number;
}

export interface AuthToken{
    token:string;
    utente:Utente;
}

export interface Registrazione{
    username:string;
    password:string;
    tipo:number;
    nome:string;
    cognome:string;
    data:string;
    via:string;
    civico:number;
    email:string;
}

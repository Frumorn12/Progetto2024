import {Component, OnInit} from '@angular/core';
import {AuthServiceService} from "../services/auth-service.service";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  admin:boolean = false;
  token: string = '';

  constructor(private auth:AuthServiceService ) { }

  ngOnInit(): void {
    // @ts-ignore
    this.token= this.auth.getToken();

    console.log("TOKEN SIDEBAR: " + this.token);




  }

  isAuthenticated(){
    console.log("isAuthenticated");
    return this.auth.isAuthenticated();
  }
  isAuthenticatedAsAdmin(){
    console.log("isAuthenticatedAsAdmin");
    return this.auth.isAuthenticatedAsAdmin();


  }

  doLogout(){
    console.log("click");
    this.auth.logout();
  }

  printUser(){


    console.log("STAMPO ADMIN: " + this.auth.printList());
  }

}

import {Component, OnInit} from '@angular/core';
import {AuthServiceService} from "../services/auth-service.service";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  admin:boolean = false;

  constructor(private auth:AuthServiceService ) { }

  ngOnInit(): void {



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

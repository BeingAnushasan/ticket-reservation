import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../service/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-the-header',
  templateUrl: './the-header.component.html',
  styleUrls: ['./the-header.component.css']
})
export class TheHeaderComponent implements OnInit {
  title :string= 'ReserveIt';

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  authenticated() {
    return this.loginService.loggedInUserValue();
  }

  logout() {
    this.loginService.logoutUser();
    this.router.navigateByUrl('/login')
  }
}

import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Demo';
  greeting = {
    id: "Hari",
    content: "How Are You ?"
  };

  constructor() { }

  ngOnInit(): void {

  }



}

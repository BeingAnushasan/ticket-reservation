import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = {username: '', password: ''};

  constructor(private loginService: LoginService, private router: Router) { }

  login() {
    {
      this.loginService.loginUser(this.credentials.username, this.credentials.password)
        .subscribe(
          data => {
            this.router.navigateByUrl('/reserve').then(r =>alert("Login Successful") );
          },
          error => {
            // console.log("error is:")
            // console.log(error);
            alert("Error: "+error.status)
          });
    }
  }

  ngOnInit(): void {
  }

}

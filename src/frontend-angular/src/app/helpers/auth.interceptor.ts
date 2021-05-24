import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {LoginService} from "../service/login.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: LoginService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let loggedInUser = this.authService.loggedInUserValue;
    let token = JSON.parse(<string>localStorage.getItem('loggedInUser'));
    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    return next.handle(request);
  }
}

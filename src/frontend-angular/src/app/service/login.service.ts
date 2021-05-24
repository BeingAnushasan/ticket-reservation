import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {BehaviorSubject, Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  // authenticated = false;
  public baseUrl = "http://localhost:8085";
  private loggedUserSubject: BehaviorSubject<unknown>;
  public loggedInUser: Observable<unknown>;

  constructor(private httpClient: HttpClient) {
    let getLoggedUser = JSON.parse(<string>localStorage.getItem('loggedInUser'));
    this.loggedUserSubject = new BehaviorSubject(getLoggedUser);
    this.loggedInUser = this.loggedUserSubject.asObservable();
  }


  loginUser(username: string, password: string) {
    return this.httpClient.post<any>(`${(this.baseUrl)}/security/login`, { username, password })
      .pipe(map(response=> {
        localStorage.setItem('loggedInUser', JSON.stringify(response.jwt));
        this.loggedUserSubject.next(response)
        console.log("the response is:")
        console.log(JSON.stringify(response));
        return response;
      }));
  }

public  loggedInUserValue(){
  return this.loggedUserSubject.value;
}
  logoutUser() {
    localStorage.removeItem('loggedInUser');
    this.loggedUserSubject.next(null);
  }

}

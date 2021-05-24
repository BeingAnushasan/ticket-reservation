import { Injectable } from '@angular/core';
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class ReserveService {
  public baseUrl = "http://localhost:8085";

  constructor(private httpClient: HttpClient) { }

  reserve(reserveRequest: { ticketInfo: { reservedDate: string; pickupTime: string; travelDate: string; arrivalTime: string; price: string; destination: string; source: string }; paymentInfo: { paidDate: string; accountNo: string; cardType: string } }) {
    return this.httpClient.post<any>(`${(this.baseUrl)}/api/v1/reserve`, reserveRequest)
      .pipe(map(response=> {
                return response;
      }));
  }

}

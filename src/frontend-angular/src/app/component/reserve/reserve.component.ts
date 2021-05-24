import { Component, OnInit } from '@angular/core';
import {ReserveService} from '../../service/reserve.service'
import {Router} from "@angular/router";

@Component({
  selector: 'app-reserve',
  templateUrl: './reserve.component.html',
  styleUrls: ['./reserve.component.css']
})
export class ReserveComponent implements OnInit {
  reserveRequest = {
    ticketInfo: {
      source: "",
      destination: "",
      travelDate: "2021-05-19",
      reservedDate: "2021-06-10",
      pickupTime: "2 PM",
      arrivalTime: "8 PM",
      price: "5005"
    },
    paymentInfo: {
      accountNo: "n/a",
      cardType: "CREDIT",
      paidDate: "2021-05-19"
    }
  }


  constructor(private reserveService: ReserveService, private router: Router) { }
  reserve() {
    this.reserveService.reserve(this.reserveRequest)
      .subscribe(
        data => {

          this.router.navigateByUrl('/').then(r =>alert(data.status));
        },
        error => {
          alert("Error: "+error.status)
        });
  }

  ngOnInit(): void {

  }

}

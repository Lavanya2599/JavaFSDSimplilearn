import { Component, OnInit } from '@angular/core';
import { Requests } from '../requests';
import { RequestsService } from '../requests.service';

@Component({
  selector: 'app-viewadhar',
  templateUrl: './viewadhar.component.html',
  styleUrls: ['./viewadhar.component.css']
})
export class ViewadharComponent implements OnInit {
  msg: string = "";
  requests: Array<Requests> = [];
  myadhar: any;
  flag: boolean = false;
  adharid: string = "";
  emailid: string = "";
  name: string = "";
  age: number = 0;
  address: string = "";
  phone: string = "";

  constructor(public rs: RequestsService) { }

  ngOnInit(): void {
    let obj = sessionStorage.getItem("userDetails");
    if (obj != null) {
      this.emailid = obj;
    }
    this.viewmyadhar(this.emailid);
  }

  approvereq(request: any) {
    this.flag = true;
    this.adharid = request.adharid;
    this.emailid = request.emailid;
    this.name = request.name;
    this.age = request.age;
    this.address = request.address;
    this.phone = request.phone;
  }

  viewmyadhar(emailid: string) {
    this.rs.viewmyAdhar(this.emailid).subscribe({
      next: (result: any) => {
        this.myadhar = JSON.parse(result);
        console.log(this.myadhar); // Log the retrieved data
        this.phone = this.phone;
      },
      error: (error: any) => console.log(error),
      complete: () => console.log("completed")
    });
  }
  

  saveReqtoDB() {
    let request = {
      adharid: this.adharid,
      emailid: this.emailid,
      name: this.name,
      age: this.age,
      address: this.address,
      phone: this.phone
    };
    this.rs.updateAdhar(request).subscribe({
      next: (result: any) => this.msg = result,
      error: (error: any) => console.log(error),
      complete: () => {
        // Reset values after update
        this.flag = false;
        this.adharid = "";
        this.emailid = "";
        this.name = "";
        this.age = 0;
        this.address = "";
        this.phone = "";
      }
    });
  }
}

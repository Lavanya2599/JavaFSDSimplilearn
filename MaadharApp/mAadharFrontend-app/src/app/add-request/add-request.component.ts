import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { RequestsService } from '../requests.service';

@Component({
  selector: 'app-add-request',
  templateUrl: './add-request.component.html',
  styleUrls: ['./add-request.component.css']
})
export class AddRequestComponent implements OnInit {

  reqRef = new FormGroup({
    emailid: new FormControl('', [Validators.required, Validators.email]),
    name: new FormControl('', Validators.required),
    age: new FormControl('', [Validators.required, Validators.min(0)]),
    address: new FormControl('', Validators.required),
    phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]*$')])
  });

  storeMsg: string = "";

  constructor(public rs: RequestsService) { }

  ngOnInit(): void {
  }

  storeRequest() {
    if (this.reqRef.valid) {
      let request = this.reqRef.value;
      console.log(request);
      this.rs.storeRequest(request).subscribe({
        next: (result: any) => this.storeMsg = result,
        error: (error: any) => console.log(error),
        complete: () => {
          this.reqRef.reset();
        }
      });
    }
  }
}

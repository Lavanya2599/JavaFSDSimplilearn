import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg: string = "";
  loginRef = new FormGroup({
    email: new FormControl(),
    pass: new FormControl()
  });

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  checkUser() {
    let login = this.loginRef.value;
    if (login.email == "lavanya@example.com" && login.pass == "lavanya") {
      this.router.navigate(["employees"]);
    } else {
      this.msg = "Failure! Try Again!";
    }
  }

}

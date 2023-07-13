import { Component, OnInit, AfterViewInit, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { FormGroup, FormControl } from "@angular/forms";
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit, AfterViewInit {

  empRef = new FormGroup({
    id: new FormControl(),
    first_name: new FormControl(),
    last_name: new FormControl(),
    email: new FormControl()
  });

  employees: Array<Employee> = [];

  constructor(public es: EmployeeService, public router: Router, private elementRef: ElementRef) { }

  ngOnInit(): void {
    this.loadEmpDetails();
  }

  ngAfterViewInit() {
    // Manually initialize the Bootstrap modal
    const modalEl = this.elementRef.nativeElement.querySelector('#exampleModal');
    if (modalEl) {
      const modal = new Modal(modalEl);
    }
  }

  loadEmpDetails() {
    this.es.loadEmpData().subscribe({
      next: (data: any) => this.employees = data,
      error: (error: any) => console.log(error),
      complete: () => console.log("Completed")
    });
  }

  storeEmp() {
    let employee = this.empRef.value;
    this.es.storeEmpData(employee).subscribe({
      next: (data: any) => {
        console.log(data);
        alert("Employee added successfully");
        this.loadEmpDetails(); // Refresh the employee list after adding a new employee
        document.getElementById("cancel")?.click(); // Close the modal after adding employee
      },
      error: (error: any) => console.log(error),
      complete: () => {}
    });
  }
  

  viewDetails(employee: any) {
    sessionStorage.setItem("empInfo", JSON.stringify(employee));
    this.router.navigate(["employee-operation"]);
  }

  logout() {
    sessionStorage.clear(); // Clear session data
    this.router.navigate([""]); // Navigate to the login page
  }
}

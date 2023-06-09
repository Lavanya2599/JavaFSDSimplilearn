import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-operation',
  templateUrl: './employee-operation.component.html',
  styleUrls: ['./employee-operation.component.css']
})
export class EmployeeOperationComponent implements OnInit {
  employee:any;
  constructor(public router:Router,public es:EmployeeService) { }

  ngOnInit(): void {
    let obj = sessionStorage.getItem("empInfo");
    if(obj != null){
        this.employee= JSON.parse(obj);
    }
  }

  ViewAll(){
    this.router.navigate(["employees"])
  }

  deleteEmployee(id:any){
    this.es.delete(id).subscribe({
      next:(result:any)=> {
        console.log(result);
        alert("Deleted successfully");
      },
      error:(error:any)=>console.log(error),
      complete:()=>this.ViewAll()
      
    })
    
  }

  updateEmployee(employee:any){
    sessionStorage.setItem("empUpd",JSON.stringify(employee));
    this.router.navigate(["employee-update"]);
    alert("Employee updated successfully");
  }

  goToEmployees() {
    // Implement the logic to navigate to the Employees page
    this.router.navigate(["employees"]);
  }

  logout() {
    sessionStorage.clear(); // Clear session data
    this.router.navigate([""]); // Navigate to the login page
  }
}
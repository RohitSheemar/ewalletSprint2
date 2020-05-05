import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  objOfUser:User=new User();
  msg:string;
  errorMsg:string;
  constructor( private refOfUserService:UserService ) { }
  ngOnInit(): void {
  }

  
  addUser(form:NgForm)
  {
    this.refOfUserService.registerUser(this.objOfUser).subscribe((data)=>
    {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      this.objOfUser=new User();
      form.resetForm();
  
  },
  error=>
  {
    this.errorMsg=JSON.parse(error.error).message;
    console.log(error.error);
    this.msg=undefined});
  }

}

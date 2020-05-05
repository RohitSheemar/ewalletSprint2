import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  objOfUser:User=new User();
  msg:string;
  errorMsg:string;
  userid:number;
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {

  }

  
  loginUser(form:NgForm)
  {
    this.refOfUserService.login(this.objOfUser.phoneNumber ,this.objOfUser.password).subscribe(data=>
    {
      console.log("user id",data);
      this.msg=data;
      this.errorMsg=undefined;
      this.userid=data;
      sessionStorage.setItem('user id',JSON.stringify(this.userid));
      alert("login successful");
      form.resetForm();

    },
    error=>
      {
        this.errorMsg=JSON.parse(error.error).message;
        console.log(error.error);
        this.msg=undefined});
  }

}

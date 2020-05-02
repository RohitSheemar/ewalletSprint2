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
  msg:String;
  errorMsg:String;
  flag: boolean=false;
  forgotflag: boolean=false;
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {
    //window.localStorage.removeItem('token');
  }

    edit()
    {
      this.flag=false;
    }

    login()
    {
      this.flag=false;
      this.forgotflag=false;
    }

    register()
    {
      
      this.flag=true;  
      alert("You are redirecting to the 'Register page' ");
    
    }

    forgotPassword()
    {
      
      this.forgotflag=true;  
      alert("You are redirecting to the 'change password page' ");
    
    }

    
  loginUser():void
  {
    this.refOfUserService.login().subscribe(data=>
    {
      alert("User sucessfully loggged in");
    },
    error=>
    {
      console.log("erroor occured",error);
    }
    );
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

     // this.flag=false;
  
  },
  error=>
  {
    //Json.parse function convert string into object to work with
    this.errorMsg=JSON.parse(error.error).message;
    console.log(error.error);
    this.msg=undefined});
  }

}

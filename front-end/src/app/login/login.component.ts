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
  }

    edit()
    {
      this.flag=false;
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

  
  addUser(form :NgForm):void
  {
    this.refOfUserService.registerUser(this.objOfUser).subscribe(data=>
    {
      form.resetForm();
      alert("User successfully registered");
  
  },
  error=>
  {
    //Json.parse function convert string into object to work with
    alert(JSON.parse(error.error).message);
    console.log("erroor occured",error);
  }
);
  }

}

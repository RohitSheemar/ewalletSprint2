import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  objOfUser:User=new User();
  flag: boolean=false;
  forgotflag: boolean=false;
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {
  }

    edit1()
    {
      this.flag=false;
    }

    edit2()
    {
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
    alert("User sucessfully loggged in");
    this.refOfUserService.login().subscribe(data=>
    {
      this.objOfUser=data;
      alert("User sucessfully loggged in");
    },
    error=>
    {
      console.log("erroor occured",error);
    }
    );
  }

}

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
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {
  }

  loginUser():void
  {
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

import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor( private refOfUserService:UserService ) { }

  objOfUser:User=new User();

  ngOnInit(): void {
  }

  addUser():void
  {
    this.refOfUserService.registerUser(this.objOfUser).subscribe(data=>
    {
      //this.objOfUser=data;
      alert("User sucessfully registered");
    },
    error=>
    {
      console.log("erroor occured",error);
    }
    );
  }

}

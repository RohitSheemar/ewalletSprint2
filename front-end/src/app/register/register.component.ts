import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor( private refOfUserService:UserService ) { }

  objOfUser:User=new User();
  msg:String;
  errorMsg:String;


  ngOnInit(): void {
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

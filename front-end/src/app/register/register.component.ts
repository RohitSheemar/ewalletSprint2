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
  msg:String;
  errorMsg:String;


  ngOnInit(): void {
  }

  addUser():void
  {
    this.refOfUserService.registerUser(this.objOfUser).subscribe(data=>
    {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      this.objOfUser=new User();
      alert("User sucessfully registered");
    },
    error=>
    {
      this.errorMsg=JSON.parse(error.error).message;
      console.log(error.error);
      this.msg=undefined
    }
    );
  }

}

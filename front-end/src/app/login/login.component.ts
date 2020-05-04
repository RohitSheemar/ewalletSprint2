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

  user:User[]=[];

  objOfUser:User=new User();
  msg:string;
  errorMsg:string;
  flag: boolean=false;
  userid:string;
  forgotflag: boolean=false;
  constructor( private refOfUserService:UserService ) { }

  ngOnInit(): void {
    localStorage.setItem('user',JSON.stringify(this.objOfUser));

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

    
  loginUser(form:NgForm)
  {
    this.refOfUserService.login(this.objOfUser.email,this.objOfUser.password).subscribe(data=>
    {
      console.log("data",data);
      this.msg=data;
      this.errorMsg=undefined;
      this.userid=data;
      alert("login successful");
      form.resetForm();

    },
    error=>
      {
        this.errorMsg=JSON.parse(error.error).message;
        console.log(error.error);
        this.msg=undefined});
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
    //Json.parse function convert string into object to work with
    this.errorMsg=JSON.parse(error.error).message;
    console.log(error.error);
    this.msg=undefined});
  }


  update(form:NgForm)
  {
    this.refOfUserService.updateUser(this.objOfUser).subscribe((data)=>
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
    console.log(error.error);
    this.msg=undefined});
  }

}

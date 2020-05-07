import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  objOfUser:User=new User();
  msg: string;
  errorMsg: string;
  editflag:boolean=false;

  index:number;

  user:User[];

  
  
  constructor( private refOfUserService:UserService, private router:Router ) { }

  ngOnInit(): void {
  }

  
  getUserByPhone()
  {
    this.refOfUserService.get(this.objOfUser.phoneNumber).subscribe(data=>
    {
      console.log("user",data);
      this.msg=data;
      this.errorMsg=undefined;
          
      alert("Mobile number verified. Proceed to update your password");



      this.refOfUserService.setUser(data);


      this.router.navigateByUrl('/reset');




    },
    error=>
      {
        this.errorMsg=JSON.parse(error.error).message;
        console.log(error.error);
        this.msg=undefined});
  }





}

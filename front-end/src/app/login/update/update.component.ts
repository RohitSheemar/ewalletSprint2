import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { NgForm } from '@angular/forms';

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

  constructor( private refOfUserService:UserService ) { }
  ngOnInit(): void {
  }

  
  
  update(form:NgForm)
  {
    this.refOfUserService.login(this.objOfUser.phoneNumber ,this.objOfUser.password).subscribe(data=>
    {
      console.log("user id",data);
      this.msg=data;
      this.errorMsg=undefined;
          
      alert("Mobile number verified. Proceed to update your password");
      form.resetForm();
      this.editflag=true;

    },
    error=>
      {
        this.errorMsg=JSON.parse(error.error).message;
        console.log(error.error);
        this.msg=undefined});
  }


}

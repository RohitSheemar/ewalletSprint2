import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from 'src/app/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/user';

@Component({
  selector: 'app-reset',
  templateUrl: './reset.component.html',
  styleUrls: ['./reset.component.css']
})
export class ResetComponent implements OnInit {


  @ViewChild("#formdata")
  form:NgForm;

  constructor( private refOfUserService:UserService, private router:Router ) { }

  objOfUser:User=new User();

  user:User = new User();

  ngOnInit(): void {
    this.user = this.refOfUserService.getUser();
   
  }
  

  updateUser()
  {
    this.refOfUserService.update(this.user).subscribe(data=>
      {

        alert("updated successfully");

        this.router.navigateByUrl('/login');

      }, 
      error=>
      {
        alert("can't update");
        console.log("error occured", error);
    });        
    
}

}

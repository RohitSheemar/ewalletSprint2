import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.css']
})
export class ViewUserComponent implements OnInit {

  constructor(private uservice:UserService) { }

 users:User[]=[];

 ngOnInit(): void {
      
    this.uservice.loaddata().subscribe(data=>
      {
        this.users=data;
      },
      error=>
      {
        console.log("erroor occured",error);
      }
      );
    
  }

}

import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  users:User[]=[];
  constructor(private http:HttpClient) { }


  login():Observable<any>
  {
    let url="http://localhost:1078/signin";
    return this.http.get(url);
  }

  registerUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1078/add";
    return this.http.post(url,userRef,{responseType:'text'});
  }



}


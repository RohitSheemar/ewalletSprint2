import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }



  public login(phoneNumber:string,password:string):Observable<any>
  {
    return this.http.get("http://localhost:1080/login/"+phoneNumber+"/"+password,{responseType:'text'});

  }

  public registerUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1080/add";
    return this.http.post(url,userRef,{responseType:'text'});
  }

  public updateUser(userId:number):Observable<any>
  {
    return this.http.put("http://localhost:1080/update/"+userId,{responseType:'text'});
  }



}


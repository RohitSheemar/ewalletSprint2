import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }



  public login(email:string,password:string):Observable<any>
  {
    return this.http.get("http://localhost:1080/login/"+email+"/"+password,{responseType:'text'});

  }

  public registerUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1080/add";
    return this.http.post(url,userRef,{responseType:'text'});
  }

  public updateUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1080/update/{userId}";
    return this.http.put(url,userRef,{responseType:'text'});
  }



}


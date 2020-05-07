import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  user:User = new User();
  
  constructor(private http:HttpClient) { }



  setUser(user:User)
  {
    this.user= user;
  }


  getUser():User
  {
    return this.user;
  }




  public login(phoneNumber:string,password:string):Observable<any>
  {
    return this.http.get("http://localhost:1080/login/"+phoneNumber+"/"+password,{responseType:'text'});

  }

  public registerUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1080/add";
    return this.http.post(url,userRef,{responseType:'text'});
  }

  public get(phoneNumber:string):Observable<any>
  {
    return this.http.get("http://localhost:1080/getUser/"+phoneNumber,{responseType:'text'});

  }


  public update(userRef:User):Observable<any>
  {
    let url = "http://localhost:1080/user/update";
    return this.http.put(url,userRef,{responseType:'text'});
  }


}


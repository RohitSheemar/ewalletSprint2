import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


  public login():Observable<any>
  {
    let url="http://localhost:1078/signin";
    return this.http.get(url);
  }

  public registerUser(userRef:User):Observable<any>
  {
    let url="http://localhost:1078/add";
    return this.http.post(url,userRef,{responseType:'text'});
  }



}


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { UserInterface } from 'src/app/interfaces/UserInterface';
import { RouterService } from '../../router.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url = "http://localhost:8083";
  private messageSubject: BehaviorSubject<String> = new BehaviorSubject(new String());

  constructor(private routerService:RouterService,private httpClient: HttpClient) { }

  signUp(user: UserInterface, password: string): Observable<any> {
    return this.httpClient.post('http://localhost:8083/user/register?password=' + password, user, {
      headers: {
        'Content-Type': 'application/json',
      }
    })
  }

  loginUser(userId: string, password: string) {
   return  this.httpClient.post<any>('http://localhost:8083/authenticate', {
      'userId': userId,
      'password': password
    }, {
      headers: {
        'Content-Type': 'application/json',
      }
    })
    //================================
    // .subscribe(data => {
    //   localStorage.setItem("token", data.token);
    //   localStorage.setItem("userId", data.userId);
    //   this.messageSubject.next(data.message);
    // }, error => {
     
    //     window.alert('Invalid credential');
    //   this.messageSubject.next(error.message.toString());
    // })
    //====================================
  }

  loginStatus() {
    let token = localStorage.getItem("token");
    if (token != null && token !== undefined)
      return true;
    else
      return false;
  }

  fetchToken() {
    return localStorage.getItem("token");
  }

  fetchUserId() {
    return localStorage.getItem("userId");
  }

  logOut() {
    localStorage.removeItem("token");
    console.log("token remove");
    return true;
  }

  getMessageSubject(): BehaviorSubject<String> {
    return this.messageSubject;
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';
import { LoginI } from '../modelos/login.interface';
import { ResponseI } from '../modelos/response.interface';
import { RegisterI } from '../modelos/register.interface';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private urlRegister = 'http://localhost:8081/auth/register';
  private urlLogin = 'http://localhost:8081/auth/login';
  private urlUser = 'http://localhost:8081/user/';
  private urlRestaurant = 'http://localhost:8081/restaurant/';
  private urlDelivery = 'http://localhost:8081/delivery/';
  private urlOrder = 'http://localhost:8081/order/';

  constructor(private http: HttpClient, private authService: AuthService) {}

  Register(form: RegisterI): Observable<ResponseI> {
    return this.http.post<ResponseI>(this.urlRegister, form);
  }

  Login(form: LoginI): Observable<ResponseI> {
    return this.http.post<ResponseI>(this.urlLogin, form);
  }

  addUser(form: LoginI): Observable<ResponseI> {
    return this.http.post<ResponseI>(this.urlUser, form);
  }

  deleteUser(form: LoginI): Observable<ResponseI> {
    let urlDeleteUser = this.urlUser + "{idUser}"
    return this.http.post<ResponseI>(urlDeleteUser, form);
  }

  User(form: LoginI): Observable<ResponseI> {
    let urlAddUser = this.urlUser + ""
    return this.http.post<ResponseI>(urlAddUser, form);
  }

}

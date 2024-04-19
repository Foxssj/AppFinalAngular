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

  addUser(form: LoginI): Observable<RegisterI> {
    return this.http.post<RegisterI>(this.urlUser, form);
  }

  deleteUser(form: LoginI): Observable<any> {
    let urlDeleteUser = this.urlUser + "{idUser}"
    return this.http.delete(urlDeleteUser);
  }

  // User(form: LoginI): Observable<RegisterI> {
  //   let urlAddUser = this.urlUser + ""
  //   return this.http.post<RegisterI>(urlAddUser, form);
  // }

  getUsers(): Observable<RegisterI[]> {
    let getUserUrl = this.urlUser + "all";
    const headers = new HttpHeaders({ 'Authorization': `Bearer ${this.authService.getToken()}` });
    return this.http.get<RegisterI[]>(getUserUrl);
  }

}

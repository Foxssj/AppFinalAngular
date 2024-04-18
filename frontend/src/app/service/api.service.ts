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

  constructor(private http: HttpClient, private authService: AuthService) {}

  Register(form: RegisterI): Observable<ResponseI> {
    return this.http.post<ResponseI>(this.urlRegister, form);
  }

  Login(form: LoginI): Observable<ResponseI> {
    return this.http.post<ResponseI>(this.urlLogin, form);
  }

}

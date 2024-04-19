import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { ApiService } from '../service/api.service';
import { RegisterI } from '../modelos/register.interface';
import {jwtDecode} from 'jwt-decode';


@Component({
  selector: 'app-user',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  constructor(private router: Router, private authService: AuthService, private api: ApiService) {}
  ngOnInit(): void {
    this.MostrarDatos()
  }

  public user = {
    username: "",
    email: ""
  }

  MostrarDatos() {

    const decodedToken: RegisterI = jwtDecode(this.authService.getToken().toString());

    this.user.username = decodedToken.username
    this.user.email = decodedToken.email
    
  }

  Logout() {
    this.authService.deleteSessionToken();
    this.router.navigate(['/login']);
  }


}

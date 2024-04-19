import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { ApiService } from '../service/api.service';
import { ResponseI } from '../modelos/response.interface';
import { RegisterI } from '../modelos/register.interface';
import {jwtDecode} from 'jwt-decode';
import { LoginI } from '../modelos/login.interface';



@Component({
  selector: 'app-home-screen',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './home-screen.component.html',
  styleUrl: './home-screen.component.css'
})
export class HomeScreenComponent implements OnInit {

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

}

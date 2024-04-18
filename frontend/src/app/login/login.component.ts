import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginI } from '../modelos/login.interface';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HttpClientModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  loginForm = {
    username: '',
    password: '',
  };

  constructor(
    private api: ApiService,
    private router: Router,
    private authService: AuthService
  ) {}

  ngOnInit(): void {}

  Login(form: LoginI) {
    if (this.loginForm.username !== '' || this.loginForm.password !== '') {
      this.api.Login(form).subscribe((data) => {
        this.authService.setToken(data.token);
        this.router.navigate(['homeScreen']);
      });
    } else {
      alert('ERROR:\nFaltan datos.');
    }
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}

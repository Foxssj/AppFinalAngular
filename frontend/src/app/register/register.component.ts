import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { RegisterI } from '../modelos/register.interface';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [HttpClientModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent implements OnInit {

  RegisterForm = {
    username: "",
    email: "",
    firstname: "",
    lastname: "",
    country: "",
    password: ""
  }

  constructor(private api: ApiService, private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
  }

  Register(form: RegisterI) {
    if (
      this.RegisterForm.username !== "" ||
      this.RegisterForm.email !== "" ||
      this.RegisterForm.firstname !== "" ||
      this.RegisterForm.lastname !== "" ||
      this.RegisterForm.country !== "" ||
      this.RegisterForm.password !== ""
    ) {
      this.api.Register(form).subscribe(data =>  {        
        this.authService.setToken(data.token);
        this.router.navigate(['homeScreen']);
      });
    } else {
      alert('ERROR:\nAlgún campo no ha sido llenado.');
    }
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}

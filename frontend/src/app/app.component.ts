import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ApiService } from './service/api.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-root',
  standalone: true,
  providers: [ApiService],
  imports: [RouterOutlet, FormsModule, HttpClientModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'LoginAngular';

  constructor(
    private router: Router,
  ) {}

  goToHome() {
    this.router.navigate(['/homeScreen']);
  }
}

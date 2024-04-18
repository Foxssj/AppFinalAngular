import { Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private tokenKey = '';

  constructor() {}

  getToken(): string | null | any {
    return localStorage.getItem(this.tokenKey);
  }

  setToken(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  deleteSessionToken(): void {
    localStorage.removeItem(this.tokenKey);
  }
}

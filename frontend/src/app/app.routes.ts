import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [
   {path: "", redirectTo: "login", pathMatch: "full"},
   { path: "register", component: RegisterComponent},
   { path: "login", component: LoginComponent},
   { path: "homeScreen", component: HomeScreenComponent, canActivate: [AuthGuard]}
   

];

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './component/login/login.component';
import { ReserveComponent } from './component/reserve/reserve.component';
import { HomeComponent } from './component/home/home.component';
import {AuthGuard} from "./auth.guard";

const routes: Routes = [
  { path: '', component: HomeComponent,canActivate: [AuthGuard] }, // visit home only if authenticated },
  { path: 'login', component: LoginComponent },
  { path: 'reserve', component: ReserveComponent,canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

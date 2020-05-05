import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UpdateComponent } from './login/update/update.component';
import { RegisterComponent } from './login/register/register.component';
import { ViewComponent } from './login/view/view.component';
import { LoggedinComponent } from './login/loggedin/loggedin.component';


const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'update',component:UpdateComponent},
  {path:'loggedin',component:LoggedinComponent},
  {path:'view',component:ViewComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

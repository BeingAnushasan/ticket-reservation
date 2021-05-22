import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TheHeaderComponent } from './component/the-header/the-header.component';
import { TheFooterComponent } from './component/the-footer/the-footer.component';
import { LoginComponent } from './component/login/login.component';
import { ReserveComponent } from './component/reserve/reserve.component';
import { HomeComponent } from './home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    TheHeaderComponent,
    TheFooterComponent,
    LoginComponent,
    ReserveComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

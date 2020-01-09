import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PriceListComponent } from './price-list/price-list.component';
import { PriceService } from './service/price.service';


@NgModule({
  declarations: [
    AppComponent,
    PriceListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PriceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

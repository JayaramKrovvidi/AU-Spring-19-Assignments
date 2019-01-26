import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { HomeComponent } from './Component/home/home.component';
import { NavBarComponent } from './Component/nav-bar/nav-bar.component';
import { FormsModule } from '@angular/forms';
import { BookComponent } from './Component/book/book.component';
import { CartComponent } from './Component/cart/cart.component';
import { SearchComponent } from './Component/search/search.component';
import { BookService } from './Providers/book.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    BookComponent,
    CartComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }

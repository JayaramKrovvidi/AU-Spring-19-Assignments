import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './Component/home/home.component';
import { SearchComponent } from './Component/search/search.component'; 
import { BookComponent } from './Component/book/book.component';
import { CartComponent } from './Component/cart/cart.component';

const routes: Routes = [
  {path: 'home',component: HomeComponent},
  { path:'', pathMatch : 'full' , redirectTo: '/home' },
  { path:'search', pathMatch:'full',component:SearchComponent},
  { path:'book/:id', component:BookComponent},
  {path:'cart',component:CartComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

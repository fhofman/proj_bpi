import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PriceListComponent } from './price-list/price-list.component';


const routes: Routes = [
  { path: 'price', component: PriceListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

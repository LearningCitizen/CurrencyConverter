import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConversionComponent } from './components/conversion/conversion.component';
import { CurrenciesComponent } from './components/currencies/currencies.component';

const routes: Routes = [
  { path : '', redirectTo : '/converter', pathMatch : 'full' },
  { path: 'converter', component: ConversionComponent },
  { path: 'currencies', component: CurrenciesComponent }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

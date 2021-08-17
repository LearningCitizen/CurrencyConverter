import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConversionComponent } from './components/conversion/conversion.component';

const routes: Routes = [
  { path : '', redirectTo : '/converter', pathMatch : 'full' },
  { path: 'converter', component: ConversionComponent }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

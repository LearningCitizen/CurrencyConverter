import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
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
export class AppRoutingModule { 

  constructor(private router: Router){}

  isActive(link: string): boolean {
    console.log(link+' res : '+this.router.url)
    return this.router.url === link;
  }

  getPaths(): string[]{
    return routes.map(route => `/${route.path}`);
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { AppRoutingModule } from 'src/app/app-routing.module';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  @Input() company: string = "Company";
  links : string[] = [];
  
  constructor(private appRouting : AppRoutingModule) { }

  ngOnInit(): void {
    this.links = this.appRouting.getPaths().filter(path => path!=='/');
  }

}

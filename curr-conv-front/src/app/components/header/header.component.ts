import { CommonModule } from '@angular/common'; 
import { BrowserModule } from '@angular/platform-browser';
import { Component, OnInit, Input } from '@angular/core';
import { AppRoutingModule } from '../../app-routing.module'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Input() title: string = "Currency Application";
  links : string[] = [];
  linksName : string[] = [];

  constructor(private appRouting : AppRoutingModule) { }

  ngOnInit(): void {
    this.links = this.appRouting.getPaths().filter(path => path!=='/');
    console.log("paths : "+this.links)
  }

  isActive(link :string) :boolean {
    let res = this.appRouting.isActive(link);
    console.log(link+" "+res)
    return res;
  }

}

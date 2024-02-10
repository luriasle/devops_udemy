import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  animales:Array<any> = [
    {tipo:'Perro', nombre:'Boby', edad:10},
    {tipo:'Gato', nombre:'Brote', edad:2},
    {tipo:'Pato', nombre:'Rafa', edad:7}
  ]

}

import { Component, OnInit } from '@angular/core';
import { ServicioService } from './../servicio.service';

@Component({
  selector: 'app-nosotros',
  templateUrl: './nosotros.component.html',
  styleUrls: ['./nosotros.component.css']
})
export class NosotrosComponent implements OnInit {

  servicio:any[] = []; 

  constructor(private _servicio:ServicioService) { 
    this.servicio = _servicio.obtenerServicio();
  } 

  ngOnInit(): void {
  }

}

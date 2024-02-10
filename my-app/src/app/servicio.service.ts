import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  servicio:any[] = [
    {
      nombre: 'Diego',
      especialidad: 'HTML',
      descripcion: 'Service is a broad category encompassing any value, function, or feature that an app needs. A service is typically a class with a narrow, well-defined purpose. It should do something specific and do it well.'
    },
    {
      nombre: 'David',
      especialidad: 'Javascript',
      descripcion: 'Service is a broad category encompassing any value, function, or feature that an app needs. A service is typically a class with a narrow, well-defined purpose. It should do something specific and do it well.'
    },
  ]

  constructor() {
    console.log('Funcionando servicio');
   }

   obtenerServicio(){
     return this.servicio;
   }

   obtenerUno(i){
     return this.servicio[i];
   }

}

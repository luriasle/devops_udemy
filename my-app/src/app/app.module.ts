import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//servicios
import { ServicioService } from './servicio.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { FooterComponent } from './footer/footer.component';
import { ContactoComponent } from './contacto/contacto.component';
import { InicioComponent } from './inicio/inicio.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { EquipoComponent } from './equipo/equipo.component';

@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    FooterComponent,
    ContactoComponent,
    InicioComponent,
    NosotrosComponent,
    EquipoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    ServicioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

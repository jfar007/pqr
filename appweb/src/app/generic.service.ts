import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GenericService {

  private estado : Array<any> = [];
  private tipo : Array<any> = [];

  constructor() {
    this.ld_constans();
  }

  private ld_constans(){
    this.estado.push({id:1, nombre: 'Creada'});
    this.estado.push({id:2, nombre: 'respondida'});

    this.tipo.push({id:1, nombre: 'Peticion'});
    this.tipo.push({id:2, nombre: 'Queja'});
    this.tipo.push({id:3, nombre: 'Reclamo'});
  }

  get estados() { return this.estado };
  get tipos() { return this.tipo };
}

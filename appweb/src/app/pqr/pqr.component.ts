import { Component, ElementRef, HostListener, Renderer2, ViewChild } from '@angular/core';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { PqrService } from '../pqr.service';
import { GenericService } from 'src/app/generic.service';
import { Paginador } from '../paginador';


@Component({
  selector: 'app-pqr',
  templateUrl: './pqr.component.html',
  styleUrls: ['./pqr.component.scss']
})
export class PqrComponent {



  headElements = ['Acciones', 'Radicado', 'Fecha', 'Tipo','Descripcion', 'Estado'];
  registros: any=[];
  estados : Array<any> = [];
  tipo : Array<any> = [];
  oldfilter: any = [];
  paginador: Paginador;


  constructor(private _pqr_service: PqrService, public _generic: GenericService) {
    this.estados = _generic.estados;
    this.tipo = _generic.tipos;

    this.paginador = new Paginador();

    this._pqr_service.pqrs()
      .subscribe((data: any) => {
        console.log(data);
        if(data.objects && data.objects.length > 0){
            this.registros =data.objects;
            this.oldfilter = data.objects;
            this.paginador.setlist(data.objects.length);
        }
      }
      );
  }


  buscarpqr(dato: string) {
    this.registros = this.paginador.filterByValue(this.oldfilter, dato);
    this.paginador.setlist(this.registros.length);
  }

  originalOrder = (): number => 0;
}

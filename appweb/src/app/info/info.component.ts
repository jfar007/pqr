import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { GenericService } from '../generic.service';


@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.scss']
})
export class InfoComponent {

  cerrar = false;
  datos: any;
  estados: Array<any> = [];
  tipo: Array<any> = [];


  constructor(@Inject(MAT_DIALOG_DATA) data: any, public _generic: GenericService) {
    this.estados = _generic.estados;
    this.tipo = _generic.tipos;
    if (data != undefined) {
      this.datos = data.el;
    }

  }

  ngOnInit(): void {
  }

}

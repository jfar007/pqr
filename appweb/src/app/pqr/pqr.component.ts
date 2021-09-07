import { Component, ElementRef, HostListener, Renderer2, ViewChild } from '@angular/core';
import { MdbTableDirective } from 'angular-bootstrap-md';
import { PqrService } from '../pqr.service';
import { GenericService } from 'src/app/generic.service';
import { Paginador } from '../paginador';
import { MatDialog } from '@angular/material/dialog';
import { InfoComponent } from '../info/info.component';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-pqr',
  templateUrl: './pqr.component.html',
  styleUrls: ['./pqr.component.scss']
})
export class PqrComponent {



  headElements = ['Acciones', 'Radicado', 'Fecha', 'Tipo','Descripcion', 'Estado'];
  registros: any=[];
  estados : Array<any> = [];
  tipos : Array<any> = [];
  oldfilter: any = [];
  paginador: Paginador;
  currentTipo: any;
  currentPQR: any;


  pqrForm = new FormGroup({
    id: new FormControl('0'),
    tipo: new FormControl('', Validators.required),
    descripcion: new FormControl('', Validators.required),
  });

  constructor(private _pqr_service: PqrService, public _generic: GenericService,   public dialog: MatDialog) {
    this.estados = _generic.estados;
    this.tipos = _generic.tipos;
    this.currentTipo = "1";
    this.paginador = new Paginador();

    this._pqr_service.pqrs()
      .subscribe((data: any) => {
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

  ver_pqr(el: any ){
    this.dialog.open(InfoComponent, { data: { el }, backdropClass: '', disableClose: true })
    .afterClosed().subscribe(result => {
      if (result) {
      }
    });
  }

  crearPQR(){
    this._pqr_service.crear_pqrs(this.pqrForm.value)
    .subscribe((data: any) => {
      if(data.objects && data.objects.length > 0){
          this.registros =data.objects;
          this.oldfilter = data.objects;
          this.paginador.setlist(data.objects.length);
          this.currentTipo = "1";
          this.currentPQR = [];
          this.pqrForm.reset({});
      }
    }
    );
  }
  crearReclamo(el : any){
    this.pqrForm.get("tipo")?.setValue("3");
    this.currentTipo = "3";
    this.currentPQR = el;
    this.pqrForm.get('id')?.setValue(el.id);
  }

  cambioTipo(){
    if (this.pqrForm.get("tipo")?.value == "3" && this.currentTipo != "3" ) {
      this.pqrForm.get("tipo")?.setValue("1");
    }
  }


get tipo() { return this.pqrForm.get('tipo'); }
get descripcion() { return this.pqrForm.get('descripcion'); }

  originalOrder = (): number => 0;
}

import { Injectable } from '@angular/core';
import { url_app, curr_version } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class PqrService {

  url_pqr : String = '/pqr';
  public current_user = "61353e03f4f12db25f1252da";

  constructor(public http: HttpClient) {

   }

  pqrs(){
    return this.http.get((url_app + curr_version + this.url_pqr + '/pqrs'));
  }

  crear_pqrs(data: any){
    return this.http.post((url_app + curr_version + this.url_pqr + '/crear'),data);
  }

}

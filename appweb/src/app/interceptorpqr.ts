import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { PqrService } from './pqr.service';
@Injectable()
export class Interceptorpqr implements HttpInterceptor {
  constructor(private pqr: PqrService) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(req);
    if (req.body && req.body.userId === undefined && this.pqr.current_user) {
      req = req.clone({ headers: req.headers.set('userId', this.pqr.current_user) });
    }
    return next.handle(req);
  }
}
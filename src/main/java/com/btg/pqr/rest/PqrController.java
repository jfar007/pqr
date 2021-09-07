package com.btg.pqr.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btg.pqr.entidades.Pqr;
import com.btg.pqr.entidades.Respuesta;
import com.btg.pqr.mensaje.MensajeRespuesta;
import com.btg.pqr.servicios.PqrService;
import com.btg.pqr.servicios.RespuestaService;

@RestController
@RequestMapping("/api/v1/pqr")
@CrossOrigin(origins = { "http://localhost:4200"})
public class PqrController {
	List<Pqr> pqrs = new ArrayList<Pqr>();
	String user = "61353e03f4f12db25f1252da";
	
	@GetMapping("/pqrs")
	public ResponseEntity<MensajeRespuesta> getPqrs(HttpServletRequest request) {
		String message = "Consulta procesada correctamente.";
		try {
		List<Pqr> pqrs = pqrs(user);	
		
		return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta<Pqr>(message, 
				request.getRequestURI(),pqrs), HttpStatus.OK);	
		
		}catch(Exception e) {
			message = "No exister registros";
			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta<Pqr>(message, request.getRequestURI(), 
									e.getMessage()),HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/crear")
	public ResponseEntity<MensajeRespuesta> guardarPqr(@RequestBody Pqr pqr, HttpServletRequest request) {
		try {
			LocalDateTime now = LocalDateTime.now();

			Pqr pq = new Pqr("ab0", pqr.getDescripcion(), pqr.getTipo(), "0", 1, (pqr.getTipo() == 3 ? pqr.getId() : "0" ) , user, now.toString() ,user, now.toString()); 
//			pqrs.add(pq);
			Pqr pqr_in = new PqrService().guardarPQR(pq);
			String message = "PQR crada correctamente ";
			
			List<Pqr> pqrs = pqrs(user);
			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta<Pqr>(message, request.getRequestURI(), 
					pqrs), HttpStatus.OK);	
		}catch(Exception e) {
			String message = "Registro no se pudo crear.";
			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta<Pqr>(message, request.getRequestURI(), 
											e.getMessage()), HttpStatus.OK);
		}
	} 
	
	private List<Pqr> pqrs(String userId){
		
		List<Pqr> pqrs = new PqrService().usuarioPqrs(userId);
		
		for (Pqr object : pqrs) {
			if (object.getId_respuesta() != "0") {
				Optional<Respuesta> rsp = new RespuestaService().getRespuesta(object.getId_respuesta());
				object.setRespuesta(rsp.get());
			}
			if (object.getId_relacionado() != "0") {
				Optional<Pqr> rsppqr = new PqrService().getPqr(object.getId_relacionado());
				object.setRelacionado(rsppqr.get());
				
				if (rsppqr.get().getId_respuesta() != "0") {
					Optional<Respuesta> rsprel = new RespuestaService().getRespuesta(rsppqr.get().getId_respuesta());
					rsppqr.get().setRespuesta(rsprel.get());
				}				
			}
		}
		return pqrs;
		

//
//		for (int i = 0; i < 10 && pqrs.size() < 5; i++) {
//			Pqr ps = new Pqr(("ab" + i),"Descripcion" ,1, "abbc12323", 1, "0", "13165d22", "2021-09-11T11:30:00", "1323Abb", "2021-09-12T11:30:00");
//			Respuesta rs = new Respuesta("fw32dw" + i, "Ajustes en el proceso", "er23svc1", "2021-09-11T11:30:00", "1ccedcw3", "2021-09-11T11:30:00");
//			ps.setRespuesta(rs);
//			Pqr psrel = new Pqr(("rell" + i),"Descripcion" ,1, "abbc12323", 1, "0", "13165d22", "2021-09-11T11:30:00", "1323Abb", "2021-09-12T11:30:00");
//			Respuesta rsrel = new Respuesta("fw32dw" + i, "Ajustes en el proceso", "er23svc1", "2021-09-11T11:30:00", "1ccedcw3", "2021-09-11T11:30:00");
//			psrel.setRespuesta(rs);
//			ps.setRelacionado(psrel);
//			pqrs.add(ps);
//		}
//		
//		return pqrs;
	}
	
}

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
	
	@GetMapping("/pqrs")
	public ResponseEntity<MensajeRespuesta> getPqrs(HttpServletRequest request) {
		String message = "Consulta procesada correctamente.";
		try {
		List<Pqr> pqrs = pqrs(request.getHeader("userId"));
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
			
			Pqr pq = new Pqr("0", pqr.getDescripcion(), pqr.getTipo(), "0", 1, "0", request.getHeader("userId") , now.toString() , request.getHeader("userId"), now.toString()); 
			Pqr pqr_in = new PqrService().guardarPQR(pq);
			String message = "PQR crada correctamente Id = "  + pqr_in.getId();
			
			List<Pqr> pqrs = pqrs(request.getHeader("userId"));
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
	}
	
}

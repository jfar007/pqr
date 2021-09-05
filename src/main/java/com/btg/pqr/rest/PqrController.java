package com.btg.pqr.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btg.pqr.mensaje.MensajeRespuesta;

@RestController
@RequestMapping("/api/v1/pqr")
//@CrossOrigin(origins = { "http://localhost:4200"})
public class PqrController {
	
	@GetMapping("/all")
	public ResponseEntity<MensajeRespuesta> getAllCustomers(HttpServletRequest request) {
		String message = "hola!";
		List test = new ArrayList<String>();
		test.add("JAAT SERVER");
		
		return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, 
				request.getRequestURI(),test), HttpStatus.OK);	
//		try {
//			// get all documents from MongoDB database
//			List<Customer> customers = customerService.retrieveAllCustomers();
//			
//			String message = "Retrieve all Customer successfully!";
//			
//			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, 
//									request.getRequestURI(), customers), HttpStatus.OK);	
//		}catch(Exception e) {
//			String message = "Can NOT retrieve all data from MongoDB database";
//			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, request.getRequestURI(), 
//									e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
}

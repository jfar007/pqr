package com.btg.pqr.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.pqr.entidades.Respuesta;
import com.btg.pqr.repositorios.RespuestaRepositorio;

@Service
public class RespuestaService {

	@Autowired
	RespuestaRepositorio repo;
	
	public Respuesta guardarRespuesta(Respuesta respuesta){
		return repo.save(respuesta);
	}
	
	public List<Respuesta> allRespuestas(){
		return repo.findAll();
	}
	
	public Optional<Respuesta> getRespuesta(String id) {
		return repo.findById(id);
	}
	

	
}

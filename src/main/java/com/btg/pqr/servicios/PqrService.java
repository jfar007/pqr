package com.btg.pqr.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.pqr.entidades.Pqr;
import com.btg.pqr.repositorios.PqrRepositorio;

@Service
public class PqrService {

	@Autowired
	PqrRepositorio repo;
	
	public Pqr guardarPQR(Pqr pqr){
		return repo.save(pqr);
	}
	
	public List<Pqr> allPqrs(){
		System.out.println("*****************");
		System.out.println(repo.findAll());
		System.out.println("*****************");
		return repo.findAll();
	}
	
	public Optional<Pqr> getPqr(String id) {
		return repo.findById(id);
	}
	
	public List<Pqr> usuarioPqrs(String id_usuario ){
		return repo.findByUsuario(id_usuario);
	}
	
}

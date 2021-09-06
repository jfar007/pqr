package com.btg.pqr.repositorios;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.btg.pqr.entidades.Pqr;


public interface PqrRepositorio extends MongoRepository<Pqr, String>{

	@Query("{ 'usuario_registra': ?0}")
	public List<Pqr> findByUsuario(String id);
}


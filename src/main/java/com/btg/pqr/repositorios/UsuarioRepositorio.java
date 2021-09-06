package com.btg.pqr.repositorios;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.btg.pqr.entidades.Usuario;


public interface UsuarioRepositorio extends MongoRepository<Usuario, String>{

}


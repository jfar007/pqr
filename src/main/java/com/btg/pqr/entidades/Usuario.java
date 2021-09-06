package com.btg.pqr.entidades;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "usuarios")
public class Usuario {

	@Id
	private String id;
	private String usuario;
	private String nombre;
	private String apellido;
	private Usuario usuario_registra;
	private Date fecha_registro;
	private Usuario usuario_actualiza;
	private Date fecha_actualiza;
	
	public Usuario(String id, String usuario, String nombre, String apellido, Usuario usuario_registra,
			Date fecha_registro, Usuario usuario_actualiza, Date fecha_actualiza) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario_registra = usuario_registra;
		this.fecha_registro = fecha_registro;
		this.usuario_actualiza = usuario_actualiza;
		this.fecha_actualiza = fecha_actualiza;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Usuario getUsuario_registra() {
		return usuario_registra;
	}
	public void setUsuario_registra(Usuario usuario_registra) {
		this.usuario_registra = usuario_registra;
	}
	public Date getFecha_registro() {
		return fecha_registro;
	}
	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	public Usuario getUsuario_actualiza() {
		return usuario_actualiza;
	}
	public void setUsuario_actualiza(Usuario usuario_actualiza) {
		this.usuario_actualiza = usuario_actualiza;
	}
	public Date getFecha_actualiza() {
		return fecha_actualiza;
	}
	public void setFecha_actualiza(Date fecha_actualiza) {
		this.fecha_actualiza = fecha_actualiza;
	}
	
	
	
}

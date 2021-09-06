package com.btg.pqr.entidades;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pqr")
public class Pqr {

	@Id
	private String id;
	@Field
	private String descripcion;
	@Field
	private Integer tipo;	
	private Respuesta respuesta;
	@Field
	private String id_respuesta;
	@Field
	private Integer estado;
	private Pqr relacionado;
	@Field
	private String id_relacionado;
	@Field
	private String usuario_registra;	
	@Field
	private String fecha_registro;
	@Field
	private String usuario_actualiza;
	@Field
	private String fecha_actualiza;


	public Pqr(String id, String descripcion, Integer tipo, String id_respuesta, Integer estado, String id_relacionado,
			String usuario_registra, String fecha_registro, String usuario_actualiza, String fecha_actualiza) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.id_respuesta = id_respuesta;
		this.estado = estado;
		this.id_relacionado = id_relacionado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Pqr getRelacionado() {
		return relacionado;
	}

	public void setRelacionado(Pqr relacionado) {
		this.relacionado = relacionado;
	}

	public String getUsuario_registra() {
		return usuario_registra;
	}

	public void setUsuario_registra(String usuario_registra) {
		this.usuario_registra = usuario_registra;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getUsuario_actualiza() {
		return usuario_actualiza;
	}

	public void setUsuario_actualiza(String usuario_actualiza) {
		this.usuario_actualiza = usuario_actualiza;
	}

	public String getFecha_actualiza() {
		return fecha_actualiza;
	}

	public void setFecha_actualiza(String fecha_actualiza) {
		this.fecha_actualiza = fecha_actualiza;
	}
	public String getId_respuesta() {
		return id_respuesta;
	}

	public void setId_respuesta(String id_respuesta) {
		this.id_respuesta = id_respuesta;
	}

	public String getId_relacionado() {
		return id_relacionado;
	}

	public void setId_relacionado(String id_relacionado) {
		this.id_relacionado = id_relacionado;
	}

}

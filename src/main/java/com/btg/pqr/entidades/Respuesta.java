package com.btg.pqr.entidades;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "respuestas")
public class Respuesta {
	
	@Id
	private String id;
	private String respuesta;
	private String usuario_registra;
	private String fecha_registro;
	private String usuario_actualiza;
	private String fecha_actualiza;
	
	public Respuesta(String id, String respuesta, String usuario_registra, String fecha_registro,
			String usuario_actualiza, String fecha_actualiza) {
		super();
		this.id = id;
		this.respuesta = respuesta;
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

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
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
	
	
}

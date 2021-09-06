package com.btg.pqr.mensaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MensajeRespuesta<T> {
	private String message;
	private String url;
	private String error = "";
	private List<T> objects = new ArrayList<T>();

	
	public MensajeRespuesta(String message, String url, List<T> objects) {
		this.message = message;
		this.url = url;
		this.objects = objects;
	}
	
	public MensajeRespuesta(String message, String url, String error) {
		this.message = message;
		this.url = url;
		this.error = error;
	}

	public MensajeRespuesta(String message, String url) {
		this(message, url, Arrays.asList());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}
	
	
	
}


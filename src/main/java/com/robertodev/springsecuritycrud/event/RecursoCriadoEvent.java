package com.robertodev.springsecuritycrud.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	private HttpServletResponse response;
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse resp, Long codigo) {
		super(source);
		this.response = resp;
		this.codigo = codigo;
	}

	public final HttpServletResponse getResponse() {
		return response;
	}

	public final Long getCodigo() {
		return codigo;
	}
}

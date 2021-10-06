package com.mintic.tiendafront.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDto {
	
	@NotEmpty(message="El nombre de usuario es obligatorio")
	private String nombreUsuario;

	@NotEmpty(message="El password es obligatorio")
	private String password;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

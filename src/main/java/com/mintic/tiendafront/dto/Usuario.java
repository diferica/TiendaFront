package com.mintic.tiendafront.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Usuario {

	private Long id;
	
	
	@NotNull(message="El tipo de documento es obligatorio")
	private Long idTipoDocumento;

	@NotEmpty(message="El numero de documento es obligatorio")
	private String numeroDocumento;

	@NotEmpty(message="El nombre es obligatorio")
	private String nombre;

	@NotEmpty(message="El email es obligatorio")
	private String email;

	@NotEmpty(message="El password es obligatorio")
	private String password;

	@NotEmpty(message="El nombre de usuario es obligatorio")
	private String nombreUsuario;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}

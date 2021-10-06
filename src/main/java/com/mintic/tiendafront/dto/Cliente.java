package com.mintic.tiendafront.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Cliente {
	
	
	private Long id;

	@NotNull(message="El tipo de documento es obligatorio")
	private Long idTipoDocumento;

	@NotEmpty(message="El numero de documento es obligatorio")
	private String numeroDocumento;

	@NotEmpty(message="La direccion es obligatorio")
	private String direccion;

	@NotEmpty(message="El email es obligatorio")
	private String email;

	@NotEmpty(message="El nombre es obligatorio")
	private String nombre;

	@NotEmpty(message="El telefono es obligatorio")
	private String telefono;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}

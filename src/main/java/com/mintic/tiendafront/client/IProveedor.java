package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorNit;


public interface IProveedor {

	public List<Proveedor> getProveedor();

	public Proveedor nuevoProveedor(Proveedor proveedorDto);

	public Proveedor buscarProveedor(Long id);

	public Proveedor buscarProveedorNit( ProveedorNit parametro);

	public int borrarProveedor(Long id);
}

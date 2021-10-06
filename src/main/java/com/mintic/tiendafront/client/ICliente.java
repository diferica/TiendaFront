package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteResponse;

public interface ICliente {
	public List<ClienteResponse> getCliente();

	public ClienteResponse nuevoCliente(Cliente clienteDto);

	public ClienteResponse buscarCliente(Long id);

	public ClienteResponse buscarClienteDocumento(ClienteDocumento clienteDto);

	public void borrarCliente(Long id);
}

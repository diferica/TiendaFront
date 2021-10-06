package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteResponse;

import reactor.core.publisher.Mono;

@Service
public class ClienteIml implements ICliente {

	private static final String URL = "http://localhost:8090/tiendagenerica/v1";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<ClienteResponse> getCliente() {
		try {
			Mono<List> response = webClient.build().get().uri(URL + "/cliente").retrieve().bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public ClienteResponse nuevoCliente(Cliente clienteDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse buscarCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteResponse buscarClienteDocumento(Cliente clienteDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int borrarCliente(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

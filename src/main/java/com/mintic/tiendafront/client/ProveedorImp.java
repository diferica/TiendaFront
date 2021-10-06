package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mintic.tiendafront.dto.Proveedor;

import reactor.core.publisher.Mono;

@Service
public class ProveedorImp implements IProveedor {

	private static final String URL = "http://localhost:8090/tiendagenerica/v1";

	@Autowired
	private WebClient.Builder webClient;

	@Override
	public List<Proveedor> getProveedor() {

		try {
			Mono<List> response = webClient.build().get().uri(URL + "/proveedor").retrieve().bodyToMono(List.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Proveedor nuevoProveedor(Proveedor proveedorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscarProveedor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscarProveedorNit(Proveedor proveedorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int borrarProveedor(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

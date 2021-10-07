package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorNit;

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
		try {

			Mono<Proveedor> response = webClient.build().post().uri(URL + "/proveedor")
					.body(Mono.just(proveedorDto), Proveedor.class).retrieve().bodyToMono(Proveedor.class);

			return response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public Proveedor buscarProveedor(Long id) {
		try {
			Mono<Proveedor> response = webClient.build().get().uri(URL + "/proveedor/" + id).retrieve()
					.bodyToMono(Proveedor.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}

	}

	@Override
	public Proveedor buscarProveedorNit(ProveedorNit parametro) {
		try {
			Mono<Proveedor> response = webClient.build().post().uri(URL + "/proveedor/nit")
					.accept(MediaType.APPLICATION_JSON).body(Mono.just(parametro), LoginDto.class).retrieve()
					.bodyToMono(Proveedor.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public int borrarProveedor(Long id) {
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/proveedor/" + id).retrieve()
					.bodyToMono(Integer.class);

			 response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			
		}
		return 0;
	}

}

package com.mintic.tiendafront.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.LoginDto;

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
		try {

			ClienteResponse u = null;
			Mono<ClienteResponse> response = webClient.build().post().uri(URL + "/cliente")
					.body(Mono.just(clienteDto), ClienteResponse.class).retrieve().bodyToMono(ClienteResponse.class);

			u = response.block();
			
			System.out.println("-***-"+u.getNombre());
			return u;

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			return null;
		}
	}

	@Override
	public ClienteResponse buscarCliente(Long id) {
		try {

			Mono<ClienteResponse> response = webClient.build().get().uri(URL + "/cliente/" + id).retrieve()
					.bodyToMono(ClienteResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public ClienteResponse buscarClienteDocumento(ClienteDocumento clienteDto) {
		try {
			Mono<ClienteResponse> response = webClient.build().post().uri(URL + "/cliente/documento")
					.accept(MediaType.APPLICATION_JSON).body(Mono.just(clienteDto), LoginDto.class).retrieve()
					.bodyToMono(ClienteResponse.class);

			return response.block();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public void borrarCliente(Long id) {
		try {

			Mono<Integer> response = webClient.build().delete().uri(URL + "/cliente/" + id).retrieve()
					.bodyToMono(Integer.class);

			 response.block();

		} catch (WebClientResponseException e) {
			e.getMessage();
			System.out.println("---->" + e.getMessage());
			
		}
	}

}

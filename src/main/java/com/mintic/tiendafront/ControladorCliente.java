package com.mintic.tiendafront;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.client.ICliente;
import com.mintic.tiendafront.dto.Cliente;
import com.mintic.tiendafront.dto.ClienteDocumento;
import com.mintic.tiendafront.dto.ClienteResponse;
import com.mintic.tiendafront.dto.Usuario;

@Controller
public class ControladorCliente {

	@Autowired
	ICliente icliente;

	@Autowired
	IClientTienda clienteTienda;

	@GetMapping("/cliente")
	public String cliente(Model model) {

		model.addAttribute("clientes", icliente.getCliente());
		return "cliente";
	}

	@PostMapping("/clienteDocumento")
	public String clienteDocumento(Model model, @ModelAttribute ClienteDocumento parametro) {

		if (parametro.getNumeroDocumento().length() > 0) {
			ClienteResponse cliente = icliente.buscarClienteDocumento(parametro);
			model.addAttribute("clientes", cliente);
		} else {
			model.addAttribute("clientes", icliente.getCliente());
		}

		return "cliente";
	}

	@GetMapping("/clienteNuevo")
	public String clienteNuevo(Model model) {

		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("clienteEditar", new ClienteResponse());
		model.addAttribute("cliente", new Cliente());

		return "clienteNuevo";
	}

	@PostMapping("/cliente")
	public String clienteCrear(Model model, @Valid @ModelAttribute Cliente cliente, BindingResult result) {

		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("clienteEditar", new ClienteResponse());
		

		if (result.hasErrors()) {

			return "clienteNuevo";
		}

		icliente.nuevoCliente(cliente);
		model.addAttribute("clientes", icliente.getCliente());
		return "cliente";
	}

	@GetMapping("/cliente/{id}")
	public String actualizarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("cliente", new Cliente());
		ClienteResponse clienteEditar = icliente.buscarCliente(id);

		model.addAttribute("clienteEditar", clienteEditar);
		return "clienteNuevo";
	}

	@GetMapping("/eliminarCliente/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") Long id) {
		icliente.borrarCliente(id);
		model.addAttribute("clientes", icliente.getCliente());
		return "cliente";
	}
	
	@GetMapping("/reporteCliente")
	public String reporteCliente (Model model) {
		
		model.addAttribute("clientes", icliente.getCliente());
		return "reporteCliente";
		
	}

	
	
}

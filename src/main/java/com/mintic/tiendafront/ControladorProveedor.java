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
import com.mintic.tiendafront.client.IProveedor;
import com.mintic.tiendafront.dto.Proveedor;
import com.mintic.tiendafront.dto.ProveedorNit;


@Controller
public class ControladorProveedor {

	@Autowired
	IProveedor iproveedor;
	
	
	@GetMapping("/proveedor")
	public String proveedor(Model model) {
		
		model.addAttribute("proveedor", iproveedor.getProveedor());
		return "proveedor";
	}
	

	@PostMapping("/proveedorNit")
	public String proveedorNit(Model model, @ModelAttribute ProveedorNit parametro) {

		
		
		if (parametro.getNit().length() > 0) {
			Proveedor proveedor= iproveedor.buscarProveedorNit(parametro);
			
			System.out.println("-----"+proveedor.getNombre());
			
			model.addAttribute("proveedor", proveedor);
		} else {
			model.addAttribute("proveedor",iproveedor.getProveedor());
		}

		return "proveedor";
	}

	@GetMapping("/proveedorNuevo")
	public String proveedorNuevo(Model model) {

		model.addAttribute("proveedorEditar", new Proveedor());
		model.addAttribute("proveedor", new Proveedor());

		return "proveedorNuevo";
	}

	@PostMapping("/proveedor")
	public String proveedorCrear(Model model, @Valid @ModelAttribute Proveedor proveedor, BindingResult result) {

		model.addAttribute("proveedorEditar", new Proveedor());
		

		if (result.hasErrors()) {

			return "proveedorNuevo";
		}

		iproveedor.nuevoProveedor(proveedor);
		model.addAttribute("proveedor",iproveedor.getProveedor());
		return "proveedor";
	}

	@GetMapping("/proveedor/{id}")
	public String actualizarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("proveedor", new Proveedor());
		Proveedor proveedorEditar = iproveedor.buscarProveedor(id);
		model.addAttribute("proveedorEditar", proveedorEditar);
		return "proveedorNuevo";
	}

	@GetMapping("/eliminarProveedor/{id}")
	public String eliminarProveedor(Model model, @PathVariable(name = "id") Long id) {
		iproveedor.borrarProveedor(id);
		model.addAttribute("proveedor",iproveedor.getProveedor());
		return "proveedor";
	}

	
	
	
}

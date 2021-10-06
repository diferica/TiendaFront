package com.mintic.tiendafront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mintic.tiendafront.client.IProveedor;

@Controller
public class ControladorProveedor {

	@Autowired
	IProveedor iproveedor;
	
	@GetMapping("/proveedor")
	public String proveedor(Model model) {
		
		model.addAttribute("proveedor", iproveedor.getProveedor());
		return "proveedor";
	}
}

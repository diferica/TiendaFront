package com.mintic.tiendafront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorVenta {

	@GetMapping("/venta")
	public String factura() {
		return "venta";
	}

	@PostMapping("/venta")
	public String nuevaFactura(@RequestParam(name = "idProducto[]", required = false) Long[] producto
			) {
		
		
		for(int i = 0;i<producto.length;i++) {
			System.out.println("prueba"+producto[i]);
		}
		
		
		return "venta";
	}

}

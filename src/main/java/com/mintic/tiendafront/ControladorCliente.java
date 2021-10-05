package com.mintic.tiendafront;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorCliente {

	@GetMapping("/cliente")
	public String cliente() {
		return "cliente";
	}
}

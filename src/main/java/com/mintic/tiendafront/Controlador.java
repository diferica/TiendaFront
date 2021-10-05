package com.mintic.tiendafront;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mintic.tiendafront.client.IClientTienda;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.Producto;
import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Controller
public class Controlador {

	@Autowired
	IClientTienda clienteTienda;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("loginDto", new LoginDto());
		return "index";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@PostMapping("/login")
	public String login(Model model, @Valid @ModelAttribute LoginDto loginDto, BindingResult result) {

		if (result.hasErrors()) {
			return "index";
		}
		int validLogin = clienteTienda.login(loginDto);
		if (validLogin == 1) {
			return "menu";
		} else {
			model.addAttribute("error", "usuario y clave incorrecta");
			return "index";
		}

	}

	@GetMapping("/usuario")
	public String usuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuario";
	}

	@PostMapping("/usuario")
	public String crearUsuario(Model model, @Valid @ModelAttribute Usuario usuario, BindingResult result) {
		
		System.out.println("----"+usuario.getIdTipoDocumento());
		
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		if (result.hasErrors()) {

			return "usuario";
		}

		clienteTienda.nuevoUsuario(usuario);
		model.addAttribute("message", "Registro correcto");
		model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "usuario";
	}

	@GetMapping("/usuario/{id}")
	public String actualizarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("usuario", new Usuario());
		UsuarioResponse usuarioEditar = clienteTienda.buscarUsuario(id);
		model.addAttribute("usuarioEditar", usuarioEditar);
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/eliminarusuario/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") Long id) {
		model.addAttribute("usuario", new Usuario());
		clienteTienda.borrarUsuario(id);
		model.addAttribute("usuarioEditar", new UsuarioResponse());
		model.addAttribute("tipoDocumento", clienteTienda.getTipoDocumento());
		model.addAttribute("usuarios", clienteTienda.getUsuarios());

		return "usuario";
	}

	@GetMapping("/producto")
	public String a() {
		return "producto";
	}

	@PostMapping("/producto")
	public String productos(@RequestParam("file") MultipartFile file, Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a CSV file to upload.");
			model.addAttribute("status", false);
		} else {

			try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

				CsvToBean<Producto> csvToBean = new CsvToBeanBuilder(reader).withType(Producto.class)
						.withIgnoreLeadingWhiteSpace(true).build();

				List<Producto> producto = csvToBean.parse();

				for (int i = 0; i < producto.size(); i++) {

					System.out.println(producto.get(i).getNombre());
				}

				model.addAttribute("producto", producto);
				model.addAttribute("status", true);

			} catch (Exception ex) {
				model.addAttribute("message", "An error occurred while processing the CSV file.");
				model.addAttribute("status", false);
			}
		}

		return ("producto");
	}

}

package com.mintic.tiendafront.client;

import java.util.List;

import com.mintic.tiendafront.dto.Usuario;
import com.mintic.tiendafront.dto.UsuarioResponse;
import com.mintic.tiendafront.dto.LoginDto;
import com.mintic.tiendafront.dto.TipoDocumento;

public interface IClientTienda {

	public int login(LoginDto loginDto);

	public List<UsuarioResponse> getUsuarios();

	public UsuarioResponse nuevoUsuario(Usuario usuarioDto);

	public UsuarioResponse buscarUsuario(Long id);

	public int borrarUsuario(Long id);

	public List<TipoDocumento> getTipoDocumento();
}

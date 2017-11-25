package br.com.healthtrack.dao.interfaces;

import br.com.healthtrack.model.Usuario;

public interface UsuarioDAO extends BaseDAO<Usuario> {
	Usuario autenticar(String email, String senha);
	boolean emailJaCadastrado(String email);
	String obterSenhaPorEmail(String email);
}

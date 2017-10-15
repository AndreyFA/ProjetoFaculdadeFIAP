package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

public class TesteUsuarioDAO {

	private UsuarioDAO dao;
	
	public TesteUsuarioDAO() {
		this.dao = DAOFactory.getUsuarioDAO();
	}
	
	public void deveSerPossivelCadastrarUmUsuario(Usuario usuario) {
		this.dao.cadastrar(usuario);
	}
	
	public ArrayList<Usuario> deveSerPossivelRecuperarTodosUsuarios() {
		return this.dao.obterTodos();
	}	
}

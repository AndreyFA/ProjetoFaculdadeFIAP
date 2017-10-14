package br.com.healthtrack.tests;

import java.time.LocalDate;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.model.Usuario;

public class TesteUsuarioDAO {

	private Usuario usuario;
	
	public TesteUsuarioDAO() {
		this.usuario = new Usuario(
				"Andrey Frazatti Alves", 
				LocalDate.now(), 
				175, 
				"M", 
				"meuemail@email.com.br", 
				"Senha@123");
	}
	
	public void deveSerPossivelCadastrarUmUsuario() {
		DAOFactory.getUsuarioDAO().cadastrar(this.usuario);
	}
	
	public void deveSerPossivelRecuperarUmUsuario() {
		DAOFactory.getUsuarioDAO().obterPorId(this.usuario.getCodigo());
	}
	
	public void deveSerPossivelAtualizarUmUsuario() {
		DAOFactory.getUsuarioDAO().atualizar(this.usuario);
	}
	
	public void deveSerPossivelDeletarUmUsuario() {
		DAOFactory.getUsuarioDAO().deletar(this.usuario.getCodigo());
	}
	
}

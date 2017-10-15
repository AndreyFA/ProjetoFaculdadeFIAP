package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.TipoRefeicaoDAO;
import br.com.healthtrack.model.TipoRefeicao;

public class TesteTipoRefeicaoDAO {
	
	private TipoRefeicaoDAO dao;
	
	public TesteTipoRefeicaoDAO() {
		this.dao = DAOFactory.getTipoRefeicaoDAO();
	}
	
	public void deveSerPossivelCadastrarUmTipoDeRefeicao(TipoRefeicao tipoRefeicao) {
		this.dao.cadastrar(tipoRefeicao);
	}
	
	public ArrayList<TipoRefeicao> deveSerPossivelRecuperarTodosTiposDeRefeicao() {
		return this.dao.obterTodos();
	}	
}

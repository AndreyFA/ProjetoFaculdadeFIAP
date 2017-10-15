package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.TipoAtividadeFisicaDAO;
import br.com.healthtrack.model.TipoAtividadeFisica;

public class TesteTipoAtividadeFisicaDAO {
	
	private TipoAtividadeFisicaDAO dao;
	
	public TesteTipoAtividadeFisicaDAO() {
		this.dao = DAOFactory.getTipoAtividadeFisicaDAO();
	}
	
	public void deveSerPossivelCadastrarUmTipoDeAtividadeFisica(TipoAtividadeFisica tipoAtividadeFisica) {
		dao.cadastrar(tipoAtividadeFisica);
	}
	
	public ArrayList<TipoAtividadeFisica> deveSerPossivelRecuperarTodosTiposDeAtividadesFisicas() {
		return this.dao.obterTodos();
	}
}

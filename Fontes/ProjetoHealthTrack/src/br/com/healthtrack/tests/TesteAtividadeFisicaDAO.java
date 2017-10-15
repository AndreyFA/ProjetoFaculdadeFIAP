package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.AtividadeFisicaDAO;
import br.com.healthtrack.model.AtividadeFisica;

public class TesteAtividadeFisicaDAO {

	private AtividadeFisicaDAO dao;
	
	public TesteAtividadeFisicaDAO() {
		this.dao = DAOFactory.getAtividadeFisicaDAO();
	}
	
	public void deveSerPossivelCadastarUmaAtividadeFisica(AtividadeFisica atividadeFisica) {
		this.dao.cadastrar(atividadeFisica);
	}
	
	public ArrayList<AtividadeFisica> deveSerPossivelRecuperarTodasAtividadesFisicas() {
		return this.dao.obterTodos();
	}	
}

package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.model.Peso;

public class TestePesoDAO {
	
	private PesoDAO dao;
	
	public TestePesoDAO() {
		this.dao = DAOFactory.getPesoDAO();
	}
	
	public void deveSerPossivelCadastrarUmPeso(Peso peso) {
		this.dao.cadastrar(peso);
	}
	
	public ArrayList<Peso> deveSerPossivelRecuperarTodosPesos() {
		return this.dao.obterTodos();
	}
	
}

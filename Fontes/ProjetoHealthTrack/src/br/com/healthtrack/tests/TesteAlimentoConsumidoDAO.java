package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.AlimentoConsumidoDAO;
import br.com.healthtrack.model.*;

public class TesteAlimentoConsumidoDAO {	
	
	private AlimentoConsumidoDAO dao;
	
	public TesteAlimentoConsumidoDAO() {
		this.dao = DAOFactory.getAlimentoConsumidoDAO();
	}
	
	
	public void deveSerPossivelCadastrarUmAlimentoConsumido(AlimentoConsumido alimentoConsumido) {
		this.dao.cadastrar(alimentoConsumido);;
	}
	
	public ArrayList<AlimentoConsumido> deveSerPossivelRecuperarTodosAlimentosConsumidos() {
		return this.dao.obterTodos();
	}
}

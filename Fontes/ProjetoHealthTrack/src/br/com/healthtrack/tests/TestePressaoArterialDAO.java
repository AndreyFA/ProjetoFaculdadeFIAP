package br.com.healthtrack.tests;

import java.util.ArrayList;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.healthtrack.model.PressaoArterial;

public class TestePressaoArterialDAO {
	
	private PressaoArterialDAO dao;
	
	public TestePressaoArterialDAO() {
		this.dao = DAOFactory.getPressaoArterialDAO();
	}
	
	public void deveSerPossivelCadastrarUmaPressaoArterial(PressaoArterial pressaoArterial) {
		this.dao.cadastrar(pressaoArterial);
	}
	
	public ArrayList<PressaoArterial> deveSerPossivelRecuperarTodasPressoesArteriais() {
		return this.dao.obterTodos();
	}
}

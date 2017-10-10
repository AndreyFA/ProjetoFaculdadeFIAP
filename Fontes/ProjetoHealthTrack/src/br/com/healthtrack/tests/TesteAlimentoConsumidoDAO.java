package br.com.healthtrack.tests;

import br.com.healthtrack.dao.AlimentoConsumidoDAO;
import br.com.healthtrack.model.AlimentoConsumido;

public class TesteAlimentoConsumidoDAO {
	
	public static void main(String[] args) {
		AlimentoConsumidoDAO dao = new AlimentoConsumidoDAO();
		
		for (AlimentoConsumido alimentoConsumido : dao.getAll()) {
			System.out.println("Nome: ".concat(alimentoConsumido.getUsuario().getNomeCompleto()));
			System.out.println("Alimento: ".concat(alimentoConsumido.getDescricao()));
		}
	}	
}

package br.com.healthtrack.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import br.com.healthtrack.model.AlimentoConsumido;
import br.com.healthtrack.model.TipoRefeicao;
import br.com.healthtrack.model.Usuario;

public class AlimentoConsumidoDAO {
	
	private Usuario usuarioMock = new Usuario("Usuário Mock", LocalDate.now(), 1.75F, 'M', "usuario@mock.com", "senha@123");
	private ArrayList<AlimentoConsumido> alimentosConsumidosMock;
	
	public ArrayList<AlimentoConsumido> getAll() {
		
		if(alimentosConsumidosMock != null)
			return alimentosConsumidosMock;
	
		alimentosConsumidosMock = new ArrayList<AlimentoConsumido>();
		
		for (int i = 1; i <= 10; i++) {
			alimentosConsumidosMock.add(new AlimentoConsumido(150, LocalDateTime.now(), "Alimento " + i, new TipoRefeicao("Almoço"), usuarioMock));
		}
		
		return alimentosConsumidosMock;
	}	
}

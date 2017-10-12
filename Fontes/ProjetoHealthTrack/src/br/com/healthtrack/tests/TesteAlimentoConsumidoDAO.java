package br.com.healthtrack.tests;

import java.time.LocalDateTime;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.model.*;

public class TesteAlimentoConsumidoDAO {	
	
	private AlimentoConsumido alimentoConsumido;
	
	public TesteAlimentoConsumidoDAO() {
		
		this.alimentoConsumido = new AlimentoConsumido(
				180, 
				LocalDateTime.now(), 
				"Barrinha de Cereal", 
				DAOFactory.getTipoRefeicaoDAO().obterPorId(1),
				DAOFactory.getUsuarioDAO().obterPorId(6));
	}
	
	
	public void deveSerPossivelCadastrarUmAlimentoConsumido() {
		DAOFactory.getAlimentoConsumidoDAO().cadastrar(alimentoConsumido);;
	}
	
	public void deveSerPossivelRecuperarUmAlimentoConsumido() {
		DAOFactory.getAlimentoConsumidoDAO().obterPorId(this.alimentoConsumido.getCodigo());
	}
	
	public void deveSerPossivelAtualizarUmAlimentoConsumido() {
		this.alimentoConsumido.setCalorias(150);		
		DAOFactory.getAlimentoConsumidoDAO().atualizar(this.alimentoConsumido);
	}
	
	public void deveSerPossivelDeleterUmAlimentoConsumido() {
		DAOFactory.getAlimentoConsumidoDAO().deletar(this.alimentoConsumido.getCodigo());
	}
}

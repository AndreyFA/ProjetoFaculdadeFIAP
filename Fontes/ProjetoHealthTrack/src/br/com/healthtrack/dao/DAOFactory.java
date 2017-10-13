package br.com.healthtrack.dao;

import br.com.healthtrack.dao.interfaces.*;

public final class DAOFactory {
	
	public static AlimentoConsumidoDAO getAlimentoConsumidoDAO() {
		return new OracleAlimentoConsumidoDAO();
	}
	
	public static AtividadeFisicaDAO getAtividadeFisicaDAO() {
		return new OracleAtividadeFisicaDAO();
	}
	
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static PressaoArterialDAO getPressaoArterialDAO() {
		return new OraclePressaoArterialDAO();
	}
	
	public static TipoAtividadeFisicaDAO getTipoAtividadeFisicaDAO() {
		return new OracleTipoAtividadeFisicaDAO();
	}
	
	public static TipoRefeicaoDAO getTipoRefeicaoDAO() {
		return new OracleTipoRefeicaoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}

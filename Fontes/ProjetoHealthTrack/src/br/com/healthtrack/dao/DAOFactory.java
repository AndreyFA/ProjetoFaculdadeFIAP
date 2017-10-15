package br.com.healthtrack.dao;

import br.com.healthtrack.dao.interfaces.*;

/***
 * Classe responsáve por criar as instâncias das DAOs.
 * @author Andrey Frazatti Alves
 * @version 1.0
 *
 */
public final class DAOFactory {
	
	/***
	 * Retorna uma instância de DAO para alimento consumido.
	 * @return Instância de DAO.
	 */
	public static AlimentoConsumidoDAO getAlimentoConsumidoDAO() {
		return new OracleAlimentoConsumidoDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para atividade física.
	 * @return Instância de DAO.
	 */
	public static AtividadeFisicaDAO getAtividadeFisicaDAO() {
		return new OracleAtividadeFisicaDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para peso.
	 * @return Instância de DAO.
	 */
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para pressão arterial.
	 * @return Instância de DAO.
	 */
	public static PressaoArterialDAO getPressaoArterialDAO() {
		return new OraclePressaoArterialDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para tipo de atividade física.
	 * @return Instância de DAO.
	 */
	public static TipoAtividadeFisicaDAO getTipoAtividadeFisicaDAO() {
		return new OracleTipoAtividadeFisicaDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para tipo de refeição.
	 * @return Instância de DAO.
	 */
	public static TipoRefeicaoDAO getTipoRefeicaoDAO() {
		return new OracleTipoRefeicaoDAO();
	}
	
	/***
	 * Retorna uma instância de DAO para usuário.
	 * @return Instância de DAO.
	 */
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}

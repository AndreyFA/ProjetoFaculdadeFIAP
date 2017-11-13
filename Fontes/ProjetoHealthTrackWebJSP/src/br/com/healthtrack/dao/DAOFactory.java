package br.com.healthtrack.dao;

import br.com.healthtrack.dao.interfaces.*;

/***
 * Classe respons�ve por criar as inst�ncias das DAOs.
 * @author Andrey Frazatti Alves
 * @version 1.0
 *
 */
public final class DAOFactory {
	
	/***
	 * Retorna uma inst�ncia de DAO para alimento consumido.
	 * @return Inst�ncia de DAO.
	 */
	public static AlimentoConsumidoDAO getAlimentoConsumidoDAO() {
		return new OracleAlimentoConsumidoDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para atividade f�sica.
	 * @return Inst�ncia de DAO.
	 */
	public static AtividadeFisicaDAO getAtividadeFisicaDAO() {
		return new OracleAtividadeFisicaDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para peso.
	 * @return Inst�ncia de DAO.
	 */
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para press�o arterial.
	 * @return Inst�ncia de DAO.
	 */
	public static PressaoArterialDAO getPressaoArterialDAO() {
		return new OraclePressaoArterialDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para tipo de atividade f�sica.
	 * @return Inst�ncia de DAO.
	 */
	public static TipoAtividadeFisicaDAO getTipoAtividadeFisicaDAO() {
		return new OracleTipoAtividadeFisicaDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para tipo de refei��o.
	 * @return Inst�ncia de DAO.
	 */
	public static TipoRefeicaoDAO getTipoRefeicaoDAO() {
		return new OracleTipoRefeicaoDAO();
	}
	
	/***
	 * Retorna uma inst�ncia de DAO para usu�rio.
	 * @return Inst�ncia de DAO.
	 */
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
}

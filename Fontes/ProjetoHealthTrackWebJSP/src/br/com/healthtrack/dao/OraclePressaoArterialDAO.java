package br.com.healthtrack.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.healthtrack.model.PressaoArterial;
import br.com.healthtrack.model.Usuario;

public class OraclePressaoArterialDAO extends OracleBaseDAO<PressaoArterial> implements PressaoArterialDAO {

	public OraclePressaoArterialDAO() {
		super();
	}
	
	@Override
	public ArrayList<PressaoArterial> obterTodos(Usuario usuario) {
		ArrayList<PressaoArterial> pressoesArteriais = new ArrayList<PressaoArterial>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PRESSAO_ARTERIAL "
					+ "WHERE CD_USUARIO = ? "
					+ "ORDER BY CD_PRESSAO_ARTERIAL DESC";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, usuario.getCodigo());
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				PressaoArterial pressaoArterial = new PressaoArterial();
				pressaoArterial.setCodigo(resultSet.getInt("CD_PRESSAO_ARTERIAL"));
				pressaoArterial.setPressaoSistolica(resultSet.getInt("VL_PRESSAO_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(resultSet.getInt("VL_PRESSAO_DIASTOLICA"));
				
				Date data = resultSet.getDate("DT_MEDICAO");
				Calendar dataMedicao = Calendar.getInstance();
				dataMedicao.setTimeInMillis(data.getTime());
				
				pressaoArterial.setData(dataMedicao);
				pressaoArterial.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				pressoesArteriais.add(pressaoArterial);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return pressoesArteriais;
	}

	@Override
	public PressaoArterial obterPorId(int id) {
		PressaoArterial pressaoArterial = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PRESSAO_ARTERIAL "
					+ "WHERE CD_PRESSAO_ARTERIAL = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				pressaoArterial = new PressaoArterial();
				pressaoArterial.setCodigo(resultSet.getInt("CD_PRESSAO_ARTERIAL"));
				pressaoArterial.setPressaoSistolica(resultSet.getInt("VL_PRESSAO_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(resultSet.getInt("VL_PRESSAO_DIASTOLICA"));
				
				Date data = resultSet.getDate("DT_MEDICAO");
				Calendar dataMedicao = Calendar.getInstance();
				dataMedicao.setTimeInMillis(data.getTime());
				
				pressaoArterial.setData(dataMedicao);
				pressaoArterial.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return pressaoArterial;
	}

	@Override
	public void cadastrar(PressaoArterial entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_PRESSAO_ARTERIAL ("
					+ "CD_PRESSAO_ARTERIAL,"
					+ "VL_PRESSAO_SISTOLICA,"
					+ "VL_PRESSAO_DIASTOLICA,"
					+ "DT_MEDICAO,"
					+ "DS_SITUACAO,"
					+ "CD_USUARIO) "
					+ "VALUES ("
					+ "SQ_PRESSAO_ARTERIAL.NEXTVAL,"
					+ "?,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "?,"
					+ "?)";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, entidade.getPressaoSistolica());
			statement.setInt(2, entidade.getPressaoDiastolica());
			statement.setDate(3, new Date(entidade.getData().getTimeInMillis()));
			statement.setString(4, entidade.getSituacao());
			statement.setInt(5, entidade.getUsuario().getCodigo());
			
			super.persistir(statement);	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}		
	}

	@Override
	public void atualizar(PressaoArterial entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_PRESSAO_ARTERIAL SET "
					+ "VL_PRESSAO_SISTOLICA = ?,"
					+ "VL_PRESSAO_DIASTOLICA = ?,"
					+ "DT_MEDICAO = TO_DATE(?),"
					+ "DS_SITUACAO = ?,"
					+ "CD_USUARIO = ? "
					+ "WHERE CD_PRESSAO_ARTERIAL = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, entidade.getPressaoSistolica());
			statement.setInt(2, entidade.getPressaoDiastolica());
			statement.setDate(3, new Date(entidade.getData().getTimeInMillis()));
			statement.setString(4, entidade.getSituacao());
			statement.setInt(5, entidade.getUsuario().getCodigo());
			statement.setInt(6, entidade.getCodigo());
			
			super.persistir(statement);	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}		
	}

	@Override
	public void deletar(int id) {
		try {
			String sql = ""
					+ "DELETE FROM T_HLT_PRESSAO_ARTERIAL "
					+ "WHERE CD_PRESSAO_ARTERIAL = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			super.persistir(statement);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}		
	}

	@Override
	public PressaoArterial obterUltimaPressaoArterialCadastrada(Usuario usuario) {
		PressaoArterial pressaoArterial = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PRESSAO_ARTERIAL "
					+ "WHERE ROWNUM = 1 "
					+ "  AND CD_USUARIO = ? "
					+ "ORDER BY CD_PRESSAO_ARTERIAL DESC";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, usuario.getCodigo());
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				pressaoArterial = new PressaoArterial();
				pressaoArterial.setCodigo(resultSet.getInt("CD_PRESSAO_ARTERIAL"));
				pressaoArterial.setPressaoSistolica(resultSet.getInt("VL_PRESSAO_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(resultSet.getInt("VL_PRESSAO_DIASTOLICA"));
				
				Date data = resultSet.getDate("DT_MEDICAO");
				Calendar dataMedicao = Calendar.getInstance();
				dataMedicao.setTimeInMillis(data.getTime());
				
				pressaoArterial.setData(dataMedicao);
				pressaoArterial.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return pressaoArterial;
	}

}

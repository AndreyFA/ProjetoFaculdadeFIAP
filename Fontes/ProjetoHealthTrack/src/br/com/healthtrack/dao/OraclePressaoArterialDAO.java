package br.com.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.healthtrack.model.PressaoArterial;

public class OraclePressaoArterialDAO extends OracleBaseDAO<PressaoArterial> implements PressaoArterialDAO {

	public OraclePressaoArterialDAO() {
		super();
	}
	
	@Override
	public ArrayList<PressaoArterial> obterTodos() {
		ArrayList<PressaoArterial> pressoesArteriais = new ArrayList<PressaoArterial>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PRESSAO_ARTERIAL;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				PressaoArterial pressaoArterial = new PressaoArterial();
				pressaoArterial.setPressaoSistolica(resultSet.getInt("VL_PRESSAO_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(resultSet.getInt("VL_PRESSAO_DIASTOLICA"));
				pressaoArterial.setData(LocalDate.parse(resultSet.getString("DT_MEDICAO")));
				pressaoArterial.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				pressoesArteriais.add(pressaoArterial);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
					+ "WHERE CD_PRESSAO_ARTERIAL = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				pressaoArterial = new PressaoArterial();
				pressaoArterial.setPressaoSistolica(resultSet.getInt("VL_PRESSAO_SISTOLICA"));
				pressaoArterial.setPressaoDiastolica(resultSet.getInt("VL_PRESSAO_DIASTOLICA"));
				pressaoArterial.setData(LocalDate.parse(resultSet.getString("DT_MEDICAO")));
				pressaoArterial.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
					+ "?);";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, entidade.getPressaoSistolica());
			statement.setInt(2, entidade.getPressaoDiastolica());
			statement.setString(3, entidade.getData().toString());
			statement.setString(4, entidade.getSituacao());
			statement.setInt(5, entidade.getUsuario().getCodigo());
			
			super.persistir(statement);	
			
		} catch (Exception e) {
			e.printStackTrace();
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
					+ "WHERE CD_PRESSAO_ARTERIAL = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, entidade.getPressaoSistolica());
			statement.setInt(2, entidade.getPressaoDiastolica());
			statement.setString(3, entidade.getData().toString());
			statement.setString(4, entidade.getSituacao());
			statement.setInt(5, entidade.getUsuario().getCodigo());
			statement.setInt(6, entidade.getCodigo());
			
			super.persistir(statement);	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deletar(int id) {
		try {
			String sql = ""
					+ "DELETE FROM T_HLT_PRESSAO_ARTERIAL "
					+ "WHERE CD_PRESSAO_ARTERIAL = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			super.persistir(statement);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

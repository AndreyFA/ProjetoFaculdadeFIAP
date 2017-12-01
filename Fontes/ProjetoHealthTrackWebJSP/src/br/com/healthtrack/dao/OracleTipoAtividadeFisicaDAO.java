package br.com.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.TipoAtividadeFisicaDAO;
import br.com.healthtrack.model.TipoAtividadeFisica;
import br.com.healthtrack.model.Usuario;

public class OracleTipoAtividadeFisicaDAO extends OracleBaseDAO<TipoAtividadeFisica> implements TipoAtividadeFisicaDAO {

	public OracleTipoAtividadeFisicaDAO() {
		super();
	}	
	
	@Override
	public ArrayList<TipoAtividadeFisica> obterTodos(Usuario usuario) {
		ArrayList<TipoAtividadeFisica> tiposAtividadeFisica = new ArrayList<TipoAtividadeFisica>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_TIPO_ATIVIDADE_FISICA";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				TipoAtividadeFisica tipoAtividadeFisica = new TipoAtividadeFisica();
				tipoAtividadeFisica.setCodigo(resultSet.getInt("CD_TIPO_ATIVIDADE_FISICA"));
				tipoAtividadeFisica.setNome(resultSet.getString("NM_ATIVIDADE_FISICA"));
				
				tiposAtividadeFisica.add(tipoAtividadeFisica);
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
		
		return tiposAtividadeFisica;
	}

	@Override
	public TipoAtividadeFisica obterPorId(int id) {
		TipoAtividadeFisica tipoAtividadeFisica = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_TIPO_ATIVIDADE_FISICA "
					+ "WHERE CD_TIPO_ATIVIDADE_FISICA = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				tipoAtividadeFisica = new TipoAtividadeFisica();
				tipoAtividadeFisica.setCodigo(resultSet.getInt("CD_TIPO_ATIVIDADE_FISICA"));
				tipoAtividadeFisica.setNome(resultSet.getString("NM_ATIVIDADE_FISICA"));
				
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
		
		return tipoAtividadeFisica;
	}

	@Override
	public void cadastrar(TipoAtividadeFisica entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_TIPO_ATIVIDADE_FISICA ("
					+ "CD_TIPO_ATIVIDADE_FISICA,"
					+ "NM_ATIVIDADE_FISICA) "
					+ "VALUES ("
					+ "SQ_TIPO_ATIVIDADE_FISICA.NEXTVAL,"
					+ "?)";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, entidade.getNome());
			
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
	public void atualizar(TipoAtividadeFisica entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_TIPO_ATIVIDADE_FISICA SET"
					+ "NM_ATIVIDADE_FISICA = ? "
					+ "WHERE CD_TIPO_ATIVIDADE_FISICA = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, entidade.getNome());
			statement.setInt(2, entidade.getCodigo());
			
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
					+ "DELETE FROM T_HLT_TIPO_ATIVIDADE_FISICA "
					+ "WHERE CD_TIPO_ATIVIDADE_FISICA = ?";
			
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

}

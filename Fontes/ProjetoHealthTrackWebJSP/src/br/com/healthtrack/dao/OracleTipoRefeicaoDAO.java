package br.com.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.TipoRefeicaoDAO;
import br.com.healthtrack.model.TipoRefeicao;

public class OracleTipoRefeicaoDAO extends OracleBaseDAO<TipoRefeicao> implements TipoRefeicaoDAO {

	public OracleTipoRefeicaoDAO() {
		super();
	}
	
	@Override
	public ArrayList<TipoRefeicao> obterTodos() {
		ArrayList<TipoRefeicao> tiposRefeicao = new ArrayList<TipoRefeicao>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_TIPO_REFEICAO";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				TipoRefeicao tipoRefeicao = new TipoRefeicao();
				tipoRefeicao.setCodigo(resultSet.getInt("CD_TIPO_REFEICAO"));
				tipoRefeicao.setNome(resultSet.getString("NM_REFEICAO"));
				
				tiposRefeicao.add(tipoRefeicao);
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
		
		return tiposRefeicao;
	}

	@Override
	public TipoRefeicao obterPorId(int id) {
		TipoRefeicao tipoRefeicao = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_TIPO_REFEICAO "
					+ "WHERE CD_TIPO_REFEICAO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				tipoRefeicao = new TipoRefeicao();
				tipoRefeicao.setCodigo(resultSet.getInt("CD_TIPO_REFEICAO"));
				tipoRefeicao.setNome(resultSet.getString("NM_REFEICAO"));
				
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
		
		return tipoRefeicao;
	}

	@Override
	public void cadastrar(TipoRefeicao entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_TIPO_REFEICAO ("
					+ "CD_TIPO_REFEICAO,"
					+ "NM_REFEICAO) "
					+ "VALUES ("
					+ "SQ_TIPO_REFEICAO.NEXTVAL,"
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
	public void atualizar(TipoRefeicao entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_TIPO_REFEICAO SET "
					+ "NM_REFEICAO = ? "
					+ "WHERE CD_TIPO_REFEICAO = ?";
			
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
					+ "DELETE FROM T_HLT_TIPO_REFEICAO "
					+ "WHERE CD_TIPO_REFEICAO = ?";
			
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

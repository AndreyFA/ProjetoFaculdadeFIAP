package br.com.healthtrack.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.Usuario;

public class OraclePesoDAO extends OracleBaseDAO<Peso> implements PesoDAO {

	public OraclePesoDAO() {
		super();
	}
	
	@Override
	public ArrayList<Peso> obterTodos(Usuario usuario) {
		ArrayList<Peso> pesos = new ArrayList<Peso>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PESO "
					+ "WHERE CD_USUARIO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, usuario.getCodigo());
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				Peso peso = new Peso();
				peso.setCodigo(resultSet.getInt("CD_PESO"));
				peso.setPeso(resultSet.getFloat("VL_PESO"));
				
				Date data = resultSet.getDate("DT_PESO");
				Calendar dataPeso = Calendar.getInstance();
				dataPeso.setTimeInMillis(data.getTime());
				
				peso.setData(dataPeso);
				peso.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				pesos.add(peso);
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
		
		return pesos;
	}

	@Override
	public Peso obterPorId(int id) {
		Peso peso = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PESO "
					+ "WHERE CD_PESO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				peso = new Peso();
				peso.setCodigo(resultSet.getInt("CD_PESO"));
				peso.setPeso(resultSet.getFloat("VL_PESO"));
				
				Date data = resultSet.getDate("DT_PESO");
				Calendar dataPeso = Calendar.getInstance();
				dataPeso.setTimeInMillis(data.getTime());
				
				peso.setData(dataPeso);
				peso.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
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
		
		return peso;
	}

	@Override
	public void cadastrar(Peso entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_PESO ("
					+ "CD_PESO,"
					+ "VL_PESO,"
					+ "DT_PESO,"
					+ "CD_USUARIO) "
					+ "VALUES ("
					+ "SQ_PESO.NEXTVAL,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "?)";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setFloat(1, entidade.getPeso());
			statement.setDate(2, new Date(entidade.getData().getTimeInMillis()));
			statement.setInt(3, entidade.getUsuario().getCodigo());
			
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
	public void atualizar(Peso entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_PESO SET "
					+ "VL_PESO = ?,"
					+ "DT_PESO = TO_DATE(?),"
					+ "CD_USUARIO = ? "
					+ "WHERE CD_PESO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setFloat(1, entidade.getPeso());
			statement.setDate(2, new Date(entidade.getData().getTimeInMillis()));
			statement.setInt(3, entidade.getUsuario().getCodigo());
			statement.setInt(4, entidade.getCodigo());
			
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
					+ "DELETE FROM T_HLT_PESO "
					+ "WHERE CD_PESO = ?";
			
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
	public Peso obterUltimoPesoCadastrado(Usuario usuario) {
		Peso peso = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PESO "
					+ "WHERE ROWNUM = 1 "
					+ "  AND CD_USUARIO = ? "
					+ "ORDER BY DT_PESO DESC";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, usuario.getCodigo());
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				peso = new Peso();
				peso.setCodigo(resultSet.getInt("CD_PESO"));
				peso.setPeso(resultSet.getFloat("VL_PESO"));
				
				Date data = resultSet.getDate("DT_PESO");
				Calendar dataPeso = Calendar.getInstance();
				dataPeso.setTimeInMillis(data.getTime());
				
				peso.setData(dataPeso);
				peso.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
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
		
		return peso;
	}

}

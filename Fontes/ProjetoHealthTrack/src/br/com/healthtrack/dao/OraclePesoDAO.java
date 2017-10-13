package br.com.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.model.Peso;

public class OraclePesoDAO extends OracleBaseDAO<Peso> implements PesoDAO {

	public OraclePesoDAO() {
		super();
	}
	
	@Override
	public ArrayList<Peso> obterTodos() {
		ArrayList<Peso> pesos = new ArrayList<Peso>();
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_PESO;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				Peso peso = new Peso();
				peso.setPeso(resultSet.getFloat("VL_PESO"));
				peso.setData(LocalDate.parse(resultSet.getString("DT_PESO")));
				peso.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				pesos.add(peso);
			}			
		} catch (Exception e) {
			e.printStackTrace();
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
					+ "WHERE CD_PESO = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				peso = new Peso();
				peso.setPeso(resultSet.getFloat("VL_PESO"));
				peso.setData(LocalDate.parse(resultSet.getString("DT_PESO")));
				peso.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				break;
			}			
		} catch (Exception e) {
			e.printStackTrace();
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
					+ "DT_PESO"
					+ "CD_USUARIO) "
					+ "VALUES ("
					+ "SQ_PESO.NEXTVAL,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "?);";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, entidade.getCodigo());
			statement.setString(2, entidade.getData().toString());
			statement.setInt(3, entidade.getUsuario().getCodigo());
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void atualizar(Peso entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_PESO SET "
					+ "VL_PESO = ?,"
					+ "DT_PESO = TO_DATE(2),"
					+ "CD_USUARIO = ? "
					+ "WHERE CD_PESO = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setFloat(1, entidade.getPeso());
			statement.setString(2, entidade.getData().toString());
			statement.setInt(3, entidade.getUsuario().getCodigo());
			statement.setInt(4, entidade.getCodigo());
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletar(int id) {
		try {
			String sql = ""
					+ "DELETE FROM T_HLT_PESO "
					+ "WHERE CD_PESO = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

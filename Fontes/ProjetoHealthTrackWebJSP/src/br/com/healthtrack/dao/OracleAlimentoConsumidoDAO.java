package br.com.healthtrack.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.healthtrack.dao.interfaces.AlimentoConsumidoDAO;
import br.com.healthtrack.model.AlimentoConsumido;
import br.com.healthtrack.model.Usuario;

public class OracleAlimentoConsumidoDAO extends OracleBaseDAO<AlimentoConsumido> implements AlimentoConsumidoDAO {
	
	public OracleAlimentoConsumidoDAO() {
		super();
	}
	
	@Override
	public ArrayList<AlimentoConsumido> obterTodos(Usuario usuario) {
		
		ArrayList<AlimentoConsumido> alimentosConsumidos = new ArrayList<AlimentoConsumido>();
		
		try {
			
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_ALIMENTO_CONSUMIDO "
					+ "WHERE CD_USUARIO = ? "
					+ "ORDER BY CD_ALIMENTO_CONSUMIDO DESC";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, usuario.getCodigo());
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {				
				AlimentoConsumido alimentoConsumido = new AlimentoConsumido();
				alimentoConsumido.setCodigo(resultSet.getInt("CD_ALIMENTO_CONSUMIDO"));
				alimentoConsumido.setCalorias(resultSet.getInt("NR_CALORIAS"));
				
				Date data = resultSet.getDate("HR_REFEICAO");
				Calendar dataHorario = Calendar.getInstance();
				dataHorario.setTimeInMillis(data.getTime());
				
				alimentoConsumido.setData(dataHorario);
				alimentoConsumido.setDescricao(resultSet.getString("DS_REFEICAO"));
				alimentoConsumido.setTipo(new OracleTipoRefeicaoDAO().obterPorId(resultSet.getInt("CD_TIPO_REFEICAO")));
				alimentoConsumido.setUsuario(new OracleUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));			
				
				alimentosConsumidos.add(alimentoConsumido);
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
		
		return alimentosConsumidos;
	}

	@Override
	public AlimentoConsumido obterPorId(int id) {
		
		AlimentoConsumido alimentoConsumido = null;
		
		try {
			String sql = ""
					+ "SELECT * "
					+ "FROM T_HLT_ALIMENTO_CONSUMIDO "
					+ "WHERE CD_ALIMENTO_CONSUMIDO = ? ";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);					
			
			while(resultSet.next()) {				
				alimentoConsumido = new AlimentoConsumido();
				alimentoConsumido.setCodigo(resultSet.getInt("CD_ALIMENTO_CONSUMIDO"));
				alimentoConsumido.setCalorias(resultSet.getInt("NR_CALORIAS"));
				
				Date data = resultSet.getDate("HR_REFEICAO");
				Calendar dataHorario = Calendar.getInstance();
				dataHorario.setTimeInMillis(data.getTime());
				
				alimentoConsumido.setData(dataHorario);
				alimentoConsumido.setDescricao(resultSet.getString("DS_REFEICAO"));
				alimentoConsumido.setTipo(new OracleTipoRefeicaoDAO().obterPorId(resultSet.getInt("CD_TIPO_REFEICAO")));
				alimentoConsumido.setUsuario(new OracleUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
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
		
		return alimentoConsumido;
	}

	@Override
	public void cadastrar(AlimentoConsumido entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_ALIMENTO_CONSUMIDO ("
					+ "CD_ALIMENTO_CONSUMIDO,"
					+ "NR_CALORIAS,"
					+ "HR_REFEICAO,"
					+ "DS_REFEICAO,"
					+ "CD_TIPO_REFEICAO,"
					+ "CD_USUARIO)"
					+ "VALUES ("
					+ "SQ_ALIMENTO_CONSUMIDO.NEXTVAL,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "?,"
					+ "?,"
					+ "?)";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setDouble(1, entidade.getCalorias());
			statement.setDate(2, new Date(entidade.getData().getTimeInMillis()));
			statement.setString(3, entidade.getDescricao());
			statement.setInt(4, entidade.getTipo().getCodigo());
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
	public void atualizar(AlimentoConsumido entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_ALIMENTO_CONSUMIDO SET "
					+ "NR_CALORIAS = ?,"
					+ "HR_REFEICAO = ?,"
					+ "DS_REFEICAO = ?,"
					+ "CD_TIPO_REFEICAO = ?,"
					+ "CD_USUARIO = ? "
					+ "WHERE CD_ALIMENTO_CONSUMIDO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setDouble(1, entidade.getCalorias());
			statement.setDate(2, new Date(entidade.getData().getTimeInMillis()));
			statement.setString(3, entidade.getDescricao());
			statement.setInt(4, entidade.getTipo().getCodigo());
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
					+ "DELETE FROM T_HLT_ALIMENTO_CONSUMIDO "
					+ "WHERE CD_ALIMENTO_CONSUMIDO = ?";
			
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

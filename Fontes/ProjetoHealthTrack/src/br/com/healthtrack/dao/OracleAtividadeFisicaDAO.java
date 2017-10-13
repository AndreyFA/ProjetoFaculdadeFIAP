package br.com.healthtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.AtividadeFisicaDAO;
import br.com.healthtrack.model.AtividadeFisica;

public class OracleAtividadeFisicaDAO extends OracleBaseDAO<AtividadeFisica> implements AtividadeFisicaDAO {

	public OracleAtividadeFisicaDAO() {
		super();
	}
	
	@Override
	public ArrayList<AtividadeFisica> obterTodos() {
		ArrayList<AtividadeFisica> atividadesFisicas = new ArrayList<AtividadeFisica>();		
		
		try {
			String sql = ""
					+ "SELECT *"
					+ "FROM T_HLT_ATIVIDADE_FISICA;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				AtividadeFisica atividadeFisica = new AtividadeFisica();
				atividadeFisica.setCalorias(resultSet.getInt("NR_CALORIAS"));
				atividadeFisica.setData(LocalDate.parse(resultSet.getString("DT_ATIVIDADE")));
				atividadeFisica.setHorario(LocalTime.parse(resultSet.getString("HR_ATIVIDADE")));
				atividadeFisica.setDescricao(resultSet.getString("DS_ATIVIDADE"));
				atividadeFisica.setTipo(DAOFactory.getTipoAtividadeFisicaDAO().obterPorId(resultSet.getInt("CD_TIPO_ATIVIDADE_FISICA")));
				atividadeFisica.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				atividadesFisicas.add(atividadeFisica);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atividadesFisicas;
	}

	@Override
	public AtividadeFisica obterPorId(int id) {
		AtividadeFisica atividadeFisica = null;		
		
		try {
			String sql = ""
					+ "SELECT *"
					+ "FROM T_HLT_ATIVIDADE_FISICA"
					+ "WHERE CD_ATIVIDADE_FISICA = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while (resultSet.next()) {
				atividadeFisica = new AtividadeFisica();
				atividadeFisica.setCalorias(resultSet.getInt("NR_CALORIAS"));
				atividadeFisica.setData(LocalDate.parse(resultSet.getString("DT_ATIVIDADE")));
				atividadeFisica.setHorario(LocalTime.parse(resultSet.getString("HR_ATIVIDADE")));
				atividadeFisica.setDescricao(resultSet.getString("DS_ATIVIDADE"));
				atividadeFisica.setTipo(DAOFactory.getTipoAtividadeFisicaDAO().obterPorId(resultSet.getInt("CD_TIPO_ATIVIDADE_FISICA")));
				atividadeFisica.setUsuario(DAOFactory.getUsuarioDAO().obterPorId(resultSet.getInt("CD_USUARIO")));
				
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return atividadeFisica;
	}

	@Override
	public void cadastrar(AtividadeFisica entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_ATIVIDADE_FISICA ("
					+ "CD_ATIVIDADE_FISICA,"
					+ "NR_CALORIAS,"
					+ "DT_ATIVIDADE,"
					+ "HR_ATIVIDADE,"
					+ "DS_ATIVIDADE,"
					+ "CD_TIPO_ATIVIDADE_FISICA,"
					+ "CD_USUARIO) "
					+ "VALUES ("
					+ "SQ_ATIVIDADE_FISICA.NEXTVAL,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "TO_TIMESTAMP(?),"
					+ "?"
					+ "?"
					+ "?);";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, entidade.getCalorias());
			statement.setString(2, entidade.getData().toString());
			statement.setString(3, entidade.getHorario().toString());
			statement.setString(4, entidade.getDescricao());
			statement.setInt(5, entidade.getTipo().getCodigo());
			statement.setInt(6, entidade.getUsuario().getCodigo());
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(AtividadeFisica entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_ATIVIDADE_FISICA SET "
					+ "NR_CALORIAS = ?,"
					+ "DT_ATIVIDADE = ?,"
					+ "HR_ATIVIDADE = ?,"
					+ "DS_ATIVIDADE = ?,"
					+ "CD_TIPO_ATIVIDADE_FISICA = ?,"
					+ "CD_USUARIO = ? "
					+ "WHERE CD_ATIVIDADE_FISICA = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, entidade.getCalorias());
			statement.setString(2, entidade.getData().toString());
			statement.setString(3, entidade.getHorario().toString());
			statement.setString(4, entidade.getDescricao());
			statement.setInt(5, entidade.getTipo().getCodigo());
			statement.setInt(6, entidade.getUsuario().getCodigo());
			statement.setInt(7, entidade.getCodigo());
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(int id) {
		try {
			String sql = ""
					+ "DELETE FRO T_HLT_ATIVIDADE_FISICA "
					+ "WHERE CD_ATIVIDADE_FISICA = ?";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

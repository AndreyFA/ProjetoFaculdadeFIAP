package br.com.healthtrack.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;

public class OracleUsuarioDAO extends OracleBaseDAO<Usuario> implements UsuarioDAO {
	
	public OracleUsuarioDAO() {
		super.constructor();
	}
	
	@Override
	public ArrayList<Usuario> obterTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO;";
		
		try {			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				usuario.setDataNascimento(LocalDate.parse(resultSet.getString("DT_NASCIMENTO")));
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO").toCharArray()[0]);
				usuario.setEmail(resultSet.getString("DS_EMAL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario obterPorId(int id) {
		Usuario usuario = new Usuario();
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO "
				+ "WHERE CD_USUARIO = ?";
		
		try {			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				usuario = new Usuario();
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				usuario.setDataNascimento(LocalDate.parse(resultSet.getString("DT_NASCIMENTO")));
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO").toCharArray()[0]);
				usuario.setEmail(resultSet.getString("DS_EMAL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				break;				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public void cadastrar(Usuario entidade) {
		try {
			String sql = ""
					+ "INSERT INTO T_HLT_USUARIO ("
					+ "CD_USUARIO,"
					+ "NM_USUARIO,"
					+ "DT_NASCIMENTO,"
					+ "VL_ALTURA,"
					+ "DS_GENERO,"
					+ "DS_EMAIL,"
					+ "DS_SENHA)"
					+ "VALUES ("
					+ "SQ_USUARIO.NEXTVAL,"
					+ "?,"
					+ "TO_DATE(?),"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?);";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setString(1, entidade.getNomeCompleto());
			statement.setString(2, entidade.getDataNascimento().toString());
			statement.setFloat(3, entidade.getAltura());
			statement.setString(4,  Character.toString(entidade.getGenero()));
			statement.setString(5, entidade.getEmail());
			statement.setString(6, entidade.getSenha());
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void atualizar(Usuario entidade) {
		try {
			String sql = ""
					+ "UPDATE T_HLT_USUARIO SET "
					+ "NM_USUARIO = ?,"
					+ "DT_NASCIMENTO = ?,"
					+ "VL_ALTURA = ?,"
					+ "DS_GENERO = ?,"
					+ "DS_EMAIL = ?,"
					+ "DS_SENHA = ? "
					+ "WHERE CD_USUARIO = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setString(1, entidade.getNomeCompleto());
			statement.setString(2, entidade.getDataNascimento().toString());
			statement.setFloat(3, entidade.getAltura());
			statement.setString(4,  Character.toString(entidade.getGenero()));
			statement.setString(5, entidade.getEmail());
			statement.setString(6, entidade.getSenha());
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
					+ "DELETE FROM T_HLT_USUARIO "
					+ "WHERE CD_USUARIO = ?;";
			
			PreparedStatement statement = super.connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			super.persistir(statement);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}

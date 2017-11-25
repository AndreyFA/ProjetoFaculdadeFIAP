package br.com.healthtrack.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.healthtrack.model.Usuario;
import br.com.healthtrack.utils.DateUtils;

public class OracleUsuarioDAO extends OracleBaseDAO<Usuario> implements UsuarioDAO {
	
	public OracleUsuarioDAO() {
		super();
	}
	
	@Override
	public ArrayList<Usuario> obterTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO";
		
		try {			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(resultSet.getInt("CD_USUARIO"));
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				
				Date data = resultSet.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				
				usuario.setDataNascimento(dataNascimento);
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO"));
				usuario.setEmail(resultSet.getString("DS_EMAIL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}

		return usuarios;
	}

	@Override
	public Usuario obterPorId(int id) {
		Usuario usuario = null;
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO "
				+ "WHERE CD_USUARIO = ?";
		
		try {			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultSet.getInt("CD_USUARIO"));
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				
				Date data = resultSet.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				
				usuario.setDataNascimento(dataNascimento);				
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO"));
				usuario.setEmail(resultSet.getString("DS_EMAIL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				break;				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
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
					+ "?)";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, entidade.getNomeCompleto());
			statement.setDate(2, new Date(entidade.getDataNascimento().getTimeInMillis()));
			statement.setFloat(3, entidade.getAltura());
			statement.setString(4, entidade.getGenero());
			statement.setString(5, entidade.getEmail());
			statement.setString(6, entidade.getSenha());
			
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
					+ "WHERE CD_USUARIO = ?";
			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, entidade.getNomeCompleto());
			statement.setDate(2, new Date(entidade.getDataNascimento().getTimeInMillis()));
			statement.setFloat(3, entidade.getAltura());
			statement.setString(4, entidade.getGenero());
			statement.setString(5, entidade.getEmail());
			statement.setString(6, entidade.getSenha());
			statement.setInt(7, entidade.getCodigo());
			
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
					+ "DELETE FROM T_HLT_USUARIO "
					+ "WHERE CD_USUARIO = ?";
			
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
	public Usuario autenticar(String email, String senha) {
		Usuario usuario = null;
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO "
				+ "WHERE DS_EMAIL = ? "
				+ "  AND DS_SENHA = ? ";
		
		try {			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, senha);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultSet.getInt("CD_USUARIO"));
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				
				Date data = resultSet.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				
				usuario.setDataNascimento(dataNascimento);
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO"));
				usuario.setEmail(resultSet.getString("DS_EMAIL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				break;				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}

		return usuario;
	}
	
	@Override
	public boolean emailJaCadastrado(String email) {
		Usuario usuario = null;
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO "
				+ "WHERE DS_EMAIL = ?";
		
		try {			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultSet.getInt("CD_USUARIO"));
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				
				Date data = resultSet.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				
				usuario.setDataNascimento(dataNascimento);
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO"));
				usuario.setEmail(resultSet.getString("DS_EMAIL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				break;				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}

		return usuario != null;
	}
	
	@Override
	public String obterSenhaPorEmail(String email) {
		Usuario usuario = null;
		
		String sql = ""
				+ "SELECT * "
				+ "FROM T_HLT_USUARIO "
				+ "WHERE DS_EMAIL = ?";
		
		try {			
			PreparedStatement statement = super.getConnection().prepareStatement(sql);
			statement.setString(1, email);
			
			ResultSet resultSet = super.executarBusca(statement);
			
			while(resultSet.next()) {
				usuario = new Usuario();
				usuario.setCodigo(resultSet.getInt("CD_USUARIO"));
				usuario.setNomeCompleto(resultSet.getString("NM_USUARIO"));
				
				Date data = resultSet.getDate("DT_NASCIMENTO");
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTimeInMillis(data.getTime());
				
				usuario.setDataNascimento(dataNascimento);
				usuario.setAltura(resultSet.getInt("VL_ALTURA"));
				usuario.setGenero(resultSet.getString("DS_GENERO"));
				usuario.setEmail(resultSet.getString("DS_EMAIL"));
				usuario.setSenha(resultSet.getString("DS_SENHA"));
				break;				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				super.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}			
		}

		return usuario.getSenha();
	}

}

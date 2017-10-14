package br.com.healthtrack.tests;

import br.com.healthtrack.dao.*;
import br.com.healthtrack.model.Usuario;
import br.com.healthtrack.utils.DateUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class TesteConnectionManager {

	public static void main(String[] args) {		
		
		try {
			
			Connection connection = ConnectionManager.getInstance().getConnection();
			deveSerPossivelBuscarUmUsuarioCadastrado(connection);		
			
			connection.close();
			
		} catch (SQLException e) {
			e.getStackTrace();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static boolean deveSerPossivelBuscarUmUsuarioCadastrado(Connection connection) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM T_HLT_USUARIO");
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		if (resultSet.next()) {
			usuarios.add(new Usuario(
					resultSet.getString("NM_USUARIO"),
					DateUtils.asLocalDate(resultSet.getDate("DT_NASCIMENTO")),
					resultSet.getFloat("VL_ALTURA"),
					resultSet.getString("DS_GENERO"),
					resultSet.getString("DS_EMAIL"),
					resultSet.getString("DS_SENHA")
					));
		}
		
		return usuarios.isEmpty();
	}
}

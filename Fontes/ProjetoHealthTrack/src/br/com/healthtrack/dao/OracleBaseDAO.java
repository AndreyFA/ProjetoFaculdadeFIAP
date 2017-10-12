package br.com.healthtrack.dao;

import java.sql.*;

public abstract class OracleBaseDAO<T> {
	
	protected Connection connection;
	
	protected void constructor() {
		this.connection = ConnectionManager.getInstance().getConnection();
	}

	protected ResultSet executarBusca(PreparedStatement statement) {
		ResultSet resultSet = null;
		
		try {					
			resultSet = statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	protected void persistir(PreparedStatement statement) {
		try {
			this.connection.setAutoCommit(false);
			statement.executeUpdate();
			this.connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

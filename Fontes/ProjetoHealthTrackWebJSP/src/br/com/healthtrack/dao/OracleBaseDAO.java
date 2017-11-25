package br.com.healthtrack.dao;

import java.sql.*;

public abstract class OracleBaseDAO<T> {
	
	protected Connection connection;
	
	protected OracleBaseDAO() {
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
	
	protected Connection getConnection() {
		try {		
			if(this.connection.isClosed()) {
				this.connection = null;
				this.connection = ConnectionManager.getInstance().getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.connection;
	}
	
	protected void persistir(PreparedStatement statement) throws SQLException {
		try {
			this.connection.setAutoCommit(false);
			statement.executeUpdate();
			this.connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.connection.rollback();
		}
	}
}

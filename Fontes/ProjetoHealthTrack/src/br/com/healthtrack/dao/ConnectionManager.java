package br.com.healthtrack.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static ConnectionManager instance;
	
	private ConnectionManager() {
		
	}	
	
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"SYSTEM", "12345");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}

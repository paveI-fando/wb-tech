package by.bsuir.fando.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	public static Connection connect(String dbUrl, String userName, String password) throws SQLException {
		return DriverManager.getConnection(dbUrl, userName, password);
	}
}

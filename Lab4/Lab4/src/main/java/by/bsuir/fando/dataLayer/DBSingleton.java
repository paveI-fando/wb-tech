package by.bsuir.fando.dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
	public static Connection conn = null;
	private static String dbUrl = "jdbc:mysql://localhost:3306/wt2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String dUser = "root";
	private static String dPassword = "skadjfhKFHiuugf924gfhKFLUGpf248yh8fi323*#(YR(&Y$792y94rf2yhf";
	public static Connection connect() {
		if (conn == null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			try {
				conn = DriverManager.getConnection(dbUrl, dUser, dPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else
		return conn;
	}
}

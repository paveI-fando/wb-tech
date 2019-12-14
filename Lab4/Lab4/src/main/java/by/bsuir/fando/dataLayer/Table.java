package by.bsuir.fando.dataLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.bsuir.fando.entity.Product;

public class Table {
	public static boolean create(Connection conn) throws SQLException {
		return conn.createStatement()
	    .execute("CREATE TABLE products(\n" +
	         " id integer primary key auto_increment,\n" +
	         " product_id varchar(10) not null unique,\n" +
	         " title varchar(50) not null,\n" +
	         " manufacturer varchar(50) not null,\n" +
	         " model varchar(50) not null,\n" +
	         " price float not null,\n" +
	         " amount integer not null\n" +
	         ")");
	}
	public static void insert(Connection conn, Product product) throws SQLException {
		String sql = "INSERT INTO products(product_id,title,manufacturer,model,price,amount) VALUES(?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, product.getAttribute());
        pstmt.setString(2, product.getTitle());
        pstmt.setString(3, product.getManufacturer());
        pstmt.setString(4, product.getModel());
        pstmt.setDouble(5, product.getPrice());
        pstmt.setInt(6, product.getAmount());
        pstmt.executeUpdate();
		
		
	}
}

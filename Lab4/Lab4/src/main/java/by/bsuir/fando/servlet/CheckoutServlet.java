package by.bsuir.fando.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.entity.Product;
import by.bsuir.fando.entity.User;

/**
 * Servlet implementation class Checkout
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static void insert(Connection conn, String address, String products) throws SQLException {
		String sql = "INSERT INTO orders(address, products) VALUES(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, address);
        pstmt.setString(2, products);
        pstmt.executeUpdate();
	}
	
    private List<Product> SelectProducts() {
    	List<Product> list = new ArrayList<Product>();
        try {
    		Statement stmt = DBSingleton.connect().createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM products");
    		while (rs.next()) {
    			  String product_id = rs.getString("product_id");
    			  String title = rs.getString("title");
    			  String manufacturer = rs.getString("manufacturer");
    			  String model = rs.getString("model");
    			  Double price = Double.parseDouble(rs.getString("price"));
    			  Integer amount = Integer.parseInt(rs.getString("amount"));
    			  list.add(new Product(product_id, title, manufacturer, model, price, amount));
    			}
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection = DBSingleton.connect();
		try {
			insert(connection, request.getParameter("address"), request.getParameter("products"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("productList", SelectProducts());
		getServletContext().getRequestDispatcher("/UserPage.jsp").forward(request, response);
	}

}

package by.bsuir.fando.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.entity.Product;

/**
 * Servlet implementation class AddProductToList
 */
public class AddProductToListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Product> AddToListStart(String id, String title, String manufacturer, String model, Double price, Integer amount) {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection connection = DBSingleton.connect();
			insert(connection, new Product(id, title, manufacturer, model, price, amount));
			
			java.sql.Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM products");
    		while (rs.next()) {
    			  String product_id1 = rs.getString("product_id");
    			  String title1 = rs.getString("title");
    			  String manufacturer1 = rs.getString("manufacturer");
    			  String model1 = rs.getString("model");
    			  Double price1 = Double.parseDouble(rs.getString("price"));
    			  Integer amount1 = Integer.parseInt(rs.getString("amount"));
    			  list.add(new Product(product_id1, title1, manufacturer1, model1, price1, amount1));
    			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static void insert(Connection conn, Product product) throws SQLException {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				String id = request.getParameter("id");
				String title = request.getParameter("title");
				String manufacturer = request.getParameter("manufacturer");
				String model = request.getParameter("model");
				Double price = Double.parseDouble(request.getParameter("price"));
				Integer amount = Integer.parseInt(request.getParameter("amount"));
				request.setAttribute("productList", AddToListStart(id, title, manufacturer, model, price, amount));
				getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
	}

}

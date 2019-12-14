package by.bsuir.fando.servlet;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.fando.dataLayer.DBSingleton;
import by.bsuir.fando.entity.Product;

/**
 * Servlet implementation class DeleteProductFromList
 */
public class DeleteProductFromListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Product> DeleteStart(HttpServletRequest request) {
    	List<Product> list = new ArrayList<Product>();
        try {
    		Connection connection = DBSingleton.connect();
    		Statement stmt1 = connection.createStatement();
    		String query = "DELETE FROM products WHERE product_id = '" + request.getParameter("id") + "'"; 
    		stmt1.executeUpdate(query);
    		
    		Statement stmt2 = connection.createStatement();
    		ResultSet rs2 = stmt2.executeQuery("SELECT * FROM products");
    		while (rs2.next()) {
    			  String product_id = rs2.getString("product_id");
    			  String title = rs2.getString("title");
    			  String manufacturer = rs2.getString("manufacturer");
    			  String model = rs2.getString("model");
    			  Double price = Double.parseDouble(rs2.getString("price"));
    			  Integer amount = Integer.parseInt(rs2.getString("amount"));
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
		request.setAttribute("productList", DeleteStart(request));
		getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
	}

}

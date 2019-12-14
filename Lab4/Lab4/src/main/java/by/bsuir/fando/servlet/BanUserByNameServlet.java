package by.bsuir.fando.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class BanUserByName
 */
public class BanUserByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<Product> BanUser(HttpServletRequest request) {
    	List<Product> list = new ArrayList<Product>();
        try {
    		Connection connection = DBSingleton.connect();
    		Statement stmt1 = connection.createStatement();
    		String query = "UPDATE users SET status='banned' WHERE login='" + request.getParameter("login") + "'"; 
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
	
	private List<User> SelectUsers() {
    	List<User> list = new ArrayList<User>();
        try {
    		Statement stmt = DBSingleton.connect().createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM users");
    		while (rs.next()) {
    			  String login = rs.getString("login");
    			  String email = rs.getString("email");
    			  String status = rs.getString("status");
    			  list.add(new User(login, email, status, null));
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
		// TODO Auto-generated method stub
		request.setAttribute("productList", BanUser(request));
		request.setAttribute("userList", SelectUsers());
		getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
	}

}
